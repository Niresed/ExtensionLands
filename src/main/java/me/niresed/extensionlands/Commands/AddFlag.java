package me.niresed.extensionlands.Commands;

import me.niresed.extensionlands.Blocks.ExtensionFlag;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AddFlag implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            ExtensionFlag.addExtensionFlagToPlayer(player);
        }

        return true;
    }
}
