package me.niresed.extensionlands.Listeners;

import com.palmergames.bukkit.towny.Towny;
import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownBlock;
import com.palmergames.bukkit.towny.object.WorldCoord;
import com.palmergames.bukkit.towny.tasks.TownClaim;
import me.niresed.extensionlands.Blocks.ExtensionFlag;
import me.niresed.extensionlands.Events.FlagRaisedEvent;
import me.niresed.extensionlands.Main.ExtensionLands;
import me.niresed.extensionlands.Utils.CheckLocation;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FlagRaised implements Listener {

    private final Plugin plugin = ExtensionLands.getPlugin(ExtensionLands.class);

    private final World world = Bukkit.getWorld(Objects.requireNonNull(plugin.getConfig().getString("world")));

    // TODO: town claim function
    @EventHandler
    public void onFlagRaised (FlagRaisedEvent ev) throws NotRegisteredException {

        BukkitScheduler scheduler = plugin.getServer().getScheduler();
        scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                ev.getBlock().setType(Material.AIR);
            }
        }, 1L);

        Player player = ev.getPlayer();

        if (world == null) {
            player.sendMessage(ChatColor.RED + "ExtensionLands: Something went wrong with world, please contact the administration about this error.");
            throw new NullPointerException(String.format("there is no world called %s%n", plugin.getConfig().getString("world")));
        }
        Town town = TownyAPI.getInstance().getTown(player);

        // errors
        String playerHaveAnotherCity = plugin.getConfig().getString("player have another city");
        String flagRaisedInTheWrongPlace = plugin.getConfig().getString("flag raised in the wrong place");

        if (town != null) {
            if (ExtensionFlag.hasFlagDataOfLandId(player, ev.getTag())) {
                Location location = ev.getBlock().getLocation();
                Boolean checkTheLocation = CheckLocation.checkTheArea(location, plugin, player);

                if (Boolean.TRUE.equals(checkTheLocation)) {
                    Bukkit.getLogger().info("Почти");
                    Chunk chunk = ev.getBlock().getChunk();
                    WorldCoord[] worldCoords = {new WorldCoord(world, chunk.getX(), chunk.getZ())};
                    TownClaim townClaim = new TownClaim(Towny.getPlugin(), player, town, Arrays.asList(worldCoords), false, true, false);
                    townClaim.run();
                    stats(town, location.getChunk(), player);
                    return;

                } else if (checkTheLocation != null){
                    player.sendMessage(ChatColor.RED + flagRaisedInTheWrongPlace);
                }

            } else {
                player.sendMessage(ChatColor.RED + playerHaveAnotherCity);
            }
        }

        ExtensionFlag.addExtensionFlagToPlayer(player);
    }

    private void stats(Town town, Chunk chunk, Player player) {
        String successfulPurchase = plugin.getConfig().getString("successful purchase");
        String coordinatesOfChunk = plugin.getConfig().getString("coordinates of a chunk");
        String chunkAmount = plugin.getConfig().getString("chunk amount");
        String tax = plugin.getConfig().getString("tax");

        String stat = ChatColor.GREEN + successfulPurchase;
        stat += "\n" + coordinatesOfChunk + chunk.getX() + " " + chunk.getZ();
        stat += "\n" + chunkAmount + town.getTownBlocks().toArray().length;
        stat += "\n" + tax + town.getTaxes();
        player.sendMessage(stat);
    }
}
