package me.niresed.extensionlands.Commands;

import net.kyori.adventure.text.Component;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class AddFlag implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player){
            // Player
            Player player = (Player) sender;

            // Extension flag
            ItemStack extensionFlag = new ItemStack(Material.BLACK_BANNER);

            // Copy of Extension flag for nms ItemStack
            net.minecraft.server.v1_16_R3.ItemStack assCopyExtensionFlag = CraftItemStack.asNMSCopy(extensionFlag);

            // Extension flag tag
            NBTTagCompound assExtensionFlagTag = new NBTTagCompound();

            // Set tag
            assExtensionFlagTag.setBoolean("flagData", true);
            assCopyExtensionFlag.setTag(assExtensionFlagTag);

            // End
            extensionFlag = CraftItemStack.asBukkitCopy(assCopyExtensionFlag);

            // Item meta for extension flag
            ItemMeta extensionFlagMeta = extensionFlag.getItemMeta();
            extensionFlagMeta.setCustomModelData(4324);
            extensionFlagMeta.displayName(Component.text("Land expansion flag"));
            extensionFlag.setItemMeta(extensionFlagMeta);

            // Add item to player
            player.getInventory().addItem(extensionFlag);
        }
        return true;
    }
}
