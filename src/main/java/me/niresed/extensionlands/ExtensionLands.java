package me.niresed.extensionlands;

import me.niresed.extensionlands.Entity.Flag;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;
import me.angeschossen.lands.api.land.LandWorld;

public final class ExtensionLands extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);

    }

    @EventHandler
    public void onBreak(BlockPlaceEvent event){
        Block flag = new Flag(event.getBlock().getLocation());
    }
}
