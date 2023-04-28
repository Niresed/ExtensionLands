package me.niresed.extensionlands.Commands;

import me.niresed.extensionlands.Main.ExtensionLands;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class addFlag implements CommandExecutor {
    private final static Plugin plugin = ExtensionLands.getPlugin(ExtensionLands.class);
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            ItemStack itemStack = new ItemStack(Material.BLACK_BANNER);
            BannerMeta bannerMeta = (BannerMeta) itemStack.getItemMeta();
//            ItemMeta itemMeta = itemStack.getItemMeta();
            bannerMeta.setCustomModelData(43434);
            bannerMeta.displayName(Component.text("MyFlag"));
            itemStack.setItemMeta(bannerMeta);
            player.getInventory().addItem(itemStack);
        }
        return true;
    }
}
