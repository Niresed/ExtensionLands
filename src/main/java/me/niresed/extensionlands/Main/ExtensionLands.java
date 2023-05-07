package me.niresed.extensionlands.Main;

import me.niresed.extensionlands.Commands.AddFlag;
import me.niresed.extensionlands.Listeners.BlockPlaced;
import me.niresed.extensionlands.Listeners.FlagRaised;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ExtensionLands extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new BlockPlaced(), this);
        getServer().getPluginManager().registerEvents(new FlagRaised(), this);
        Objects.requireNonNull(getCommand("AddFlag")).setExecutor(new AddFlag());

    }
}
