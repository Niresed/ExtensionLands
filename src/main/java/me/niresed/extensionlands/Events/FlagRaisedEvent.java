package me.niresed.extensionlands.Events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class FlagRaisedEvent extends Event {
    private static final HandlerList handlerList = new HandlerList();
    private final ItemStack itemStack;

    private final Block block;
    private final Player player;

    public FlagRaisedEvent(ItemStack itemStack, Block block, Player player){
        this.itemStack = itemStack;
        this.block = block;
        this.player = player;
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

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }
}
