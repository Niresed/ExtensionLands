package me.niresed.extensionlands.Events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockEvent;
import org.jetbrains.annotations.NotNull;

public class FlagRaised extends BlockEvent {
    private static final HandlerList handlerList = new HandlerList();
    private final Event event;

    private final Player player;

    public FlagRaised(Block block, Event event, Player player){
        super(block);
        this.event = event;
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }

    public Event getEvent(){
        return event;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }
}
