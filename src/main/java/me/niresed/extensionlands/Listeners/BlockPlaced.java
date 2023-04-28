package me.niresed.extensionlands.Listeners;

import me.niresed.extensionlands.Block.FlagData;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Banner;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.banner.Pattern;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class BlockPlaced implements Listener {

    @EventHandler
    public void onBlockPlaced(BlockPlaceEvent event){
        if (event.getBlock().getType() == Material.BLACK_BANNER){
            Block block = event.getBlock();
        }
    }
}
