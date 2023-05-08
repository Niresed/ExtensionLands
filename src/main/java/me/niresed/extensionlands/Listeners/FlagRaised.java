package me.niresed.extensionlands.Listeners;

import me.angeschossen.lands.api.LandsIntegration;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
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
import java.util.Objects;

public class FlagRaised implements Listener {

    private final Plugin plugin = ExtensionLands.getPlugin(ExtensionLands.class);

    private final World world = Bukkit.getWorld(Objects.requireNonNull(plugin.getConfig().getString("world")));

    @EventHandler
    public void onFlagRaised (FlagRaisedEvent ev) {

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

        LandsIntegration api = LandsIntegration.of(plugin);
        LandPlayer landPlayer = api.getLandPlayer(ev.getPlayer().getUniqueId());

        if (landPlayer == null) {
            return;
        }

        Land land = landPlayer.getOwningLand();

        // errors
        String playerHaveAnotherCity = plugin.getConfig().getString("player have another city");
        String flagRaisedInTheWrongPlace = plugin.getConfig().getString("flag raised in the wrong place");

        if (land != null) {
            if (ExtensionFlag.hasFlagDataOfLandId(landPlayer, ev.getTag())) {
                Location location = ev.getBlock().getLocation();
                Boolean checkTheLocation = CheckLocation.checkTheArea(location, plugin, landPlayer);

                if (Boolean.TRUE.equals(checkTheLocation)) {
                    Chunk chunk = ev.getBlock().getChunk();
                    land.claimChunk(landPlayer, world, chunk.getX(), chunk.getZ());
                    stats(api, land, landPlayer, location.getChunk());
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

    private void stats(LandsIntegration api, Land land, LandPlayer landPlayer, Chunk chunk) {
        Player player = landPlayer.getPlayer();

        String successfulPurchase = plugin.getConfig().getString("successful purchase");
        String coordinatesOfChunk = plugin.getConfig().getString("coordinates of a chunk");
        String chunkAmount = plugin.getConfig().getString("chunk amount");
        String tax = plugin.getConfig().getString("tax");

        String stat = ChatColor.GREEN + successfulPurchase;
        stat += "\n" + coordinatesOfChunk + chunk.getX() + " " + chunk.getZ();
        stat += "\n" + chunkAmount + land.getChunksAmount();
        stat += "\n" + tax + land.getUpkeepCosts();
        player.sendMessage(stat);
    }
}
