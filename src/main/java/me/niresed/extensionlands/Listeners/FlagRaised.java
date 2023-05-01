package me.niresed.extensionlands.Listeners;

import me.angeschossen.lands.api.LandsIntegration;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import me.niresed.extensionlands.Events.FlagRaisedEvent;
import me.niresed.extensionlands.Main.ExtensionLands;
import me.niresed.extensionlands.Utils.CheckLocation;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class FlagRaised implements Listener {
    @EventHandler
    public void onFlagRaised (FlagRaisedEvent ev) {
        ItemStack itemStack = ev.getItemStack();
        LandsIntegration api = LandsIntegration.of(ExtensionLands.getPlugin(ExtensionLands.class));
        LandPlayer landPlayer = api.getLandPlayer(ev.getPlayer().getUniqueId());
        if (landPlayer == null){
            return;
        }
        Land land = landPlayer.getOwningLand();
        if (ev.getTag().contains("flagDataOfLandId:" + Objects.requireNonNull(landPlayer.getOwningLand()).getId())) {
            Location location = ev.getBlock().getLocation();
            if (CheckLocation.checkTheArea(location, api, landPlayer)){
                assert land != null;
                land.claimChunk(landPlayer, Objects.requireNonNull(Bukkit.getWorld("world")), location.getChunk().getX(), location.getChunk().getZ());
            }
        }
    }
}
