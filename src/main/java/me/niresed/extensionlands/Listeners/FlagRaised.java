package me.niresed.extensionlands.Listeners;

import me.angeschossen.lands.api.LandsIntegration;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import me.niresed.extensionlands.Blocks.FlagData;
import me.niresed.extensionlands.Events.FlagRaisedEvent;
import me.niresed.extensionlands.Main.ExtensionLands;
import me.niresed.extensionlands.Utils.CheckLocation;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Objects;

public class FlagRaised implements Listener {
    @EventHandler
    public void onFlagRaised (FlagRaisedEvent ev) {
        LandsIntegration api = LandsIntegration.of(ExtensionLands.getPlugin(ExtensionLands.class));
        LandPlayer landPlayer = api.getLandPlayer(ev.getPlayer().getUniqueId());
        Player player = ev.getPlayer();

        if (landPlayer == null)
            return;

        Land land = landPlayer.getOwningLand();

        if (land == null) {
            player.sendMessage(ChatColor.RED + "Вы не являетесь жителем не одного города");
            return;
        }

        if (FlagData.hasFlagDataOfLandId(landPlayer, ev.getTag())) {
            Location location = ev.getBlock().getLocation();
            if (CheckLocation.checkTheArea(location, api, landPlayer)) {
                land.claimChunk(landPlayer, Objects.requireNonNull(Bukkit.getWorld("world")), ev.getBlock().getChunk().getX(), ev.getBlock().getChunk().getZ());
            }
        } else {
            player.sendMessage(ChatColor.RED + "Вы являетесь жителем другого города");
        }
    }
}
