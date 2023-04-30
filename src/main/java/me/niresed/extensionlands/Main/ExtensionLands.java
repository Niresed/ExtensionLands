package me.niresed.extensionlands.Main;

import me.niresed.extensionlands.Commands.AddFlag;
import me.niresed.extensionlands.Listeners.BlockPlaced;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ExtensionLands extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new BlockPlaced(), this);
        Objects.requireNonNull(getCommand("AddFlag")).setExecutor(new AddFlag());

    }
}
