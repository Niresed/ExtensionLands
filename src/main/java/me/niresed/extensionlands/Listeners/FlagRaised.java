package me.niresed.extensionlands.Listeners;

import me.angeschossen.lands.api.LandsIntegration;
import me.niresed.extensionlands.Events.FlagRaisedEvent;
import me.niresed.extensionlands.Main.ExtensionLands;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class FlagRaised implements Listener {
    @EventHandler
    public void onFlagRaised (FlagRaisedEvent ev) {
        LandsIntegration api = LandsIntegration.of(ExtensionLands.getPlugin(ExtensionLands.class));
        Bukkit.getLogger().info(String.valueOf(ev.getItemStack().getType()));
    }
}
