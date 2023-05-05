package me.niresed.extensionlands.Commands;

import me.niresed.extensionlands.Blocks.FlagData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class AddFlag implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            ItemStack extensionFlag = FlagData.generateExtensionFlag(player);
            if (extensionFlag != null) {
                player.getInventory().addItem(extensionFlag);
            }
        }
        return true;
    }
}
