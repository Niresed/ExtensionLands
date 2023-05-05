package me.niresed.extensionlands.Events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class FlagRaisedEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private final ItemStack itemStack;

    private final Block block;

    private final Player player;

    private final String tag;

    public FlagRaisedEvent(ItemStack itemStack, Block block, Player player, String tag){
        this.itemStack = itemStack;
        this.block = block;
        this.player = player;
        this.tag = tag;
    }

    public Player getPlayer(){
        return player;
    }

    public ItemStack getItemStack(){
        return itemStack;
    }

    public Block getBlock() {
        return block;
    }

    public String getTag() {
        return tag;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
