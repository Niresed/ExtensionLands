package me.niresed.extensionlands.Listeners;

import me.niresed.extensionlands.Events.FlagRaisedEvent;
import net.minecraft.server.v1_16_R3.TileEntityBanner;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Banner;
import org.bukkit.craftbukkit.v1_16_R3.block.CraftBanner;
import org.bukkit.craftbukkit.v1_16_R3.block.CraftBlock;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class BlockPlaced implements Listener {
    @EventHandler
    public void onBlockPlaced(BlockPlaceEvent ev) {
        if (ev.getBlock().getType() == Material.BLACK_BANNER) {
            ItemStack itemInHand = ev.getItemInHand();
            net.minecraft.server.v1_16_R3.ItemStack assItemInHandCopy = CraftItemStack.asNMSCopy(itemInHand);
            String checkTag = String.valueOf(assItemInHandCopy.getTag());

            if (checkTag.contains("flagData:1b")) {
                FlagRaisedEvent flagRaisedEvent = new FlagRaisedEvent(itemInHand, ev.getBlock(), ev.getPlayer(), checkTag);
                Bukkit.getServer().getPluginManager().callEvent(flagRaisedEvent);
            }
        }

    }

}
