package me.niresed.extensionlands.Blocks;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import me.niresed.extensionlands.Main.ExtensionLands;
import net.kyori.adventure.text.Component;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.Objects;
import java.util.Random;

public class ExtensionFlag {
    private static ItemStack generateFlag(Player player, Plugin plugin) {
        Town town = TownyAPI.getInstance().getTown(player);

        if (town == null) {
            player.sendMessage(ChatColor.RED + plugin.getConfig().getString("player hasn't city"));
            return null;
        }

        ItemStack extensionFlag = new ItemStack(Material.BLACK_BANNER, 1);

        net.minecraft.server.v1_16_R3.ItemStack assCopyExtensionFlag = CraftItemStack.asNMSCopy(extensionFlag);

        NBTTagCompound assExtensionFlagTag = new NBTTagCompound();

        assExtensionFlagTag.setBoolean("flagData", true);
        assExtensionFlagTag.setString("flagId", town.getUUID().toString());
        assExtensionFlagTag.setLong("uniqueId", new Random().nextLong());

        assCopyExtensionFlag.setTag(assExtensionFlagTag);

        extensionFlag = CraftItemStack.asBukkitCopy(assCopyExtensionFlag);

        ItemMeta extensionFlagMeta = extensionFlag.getItemMeta();
        extensionFlagMeta.setCustomModelData(4324);
        extensionFlagMeta.displayName(Component.text("Land expansion flag"));
        extensionFlag.setItemMeta(extensionFlagMeta);

        return extensionFlag;
    }

    public static void addExtensionFlagToPlayer(Player player) {
        if (player == null) {
            throw new NullPointerException("again this null ?");
        }

        Plugin plugin = ExtensionLands.getPlugin(ExtensionLands.class);
        ItemStack item = generateFlag(player, plugin);

        if (item != null) {
            if (isInventoryFull(player)) {
                player.getInventory().addItem(item);
                return;
            }

            player.sendMessage(Objects.requireNonNull(plugin.getConfig().getString("inventory is full")));

        }
    }

    private static boolean isInventoryFull(Player player) {
        int emp = player.getInventory().firstEmpty();
        return (emp != -1);
    }

    public static boolean hasFlagDataOfLandId(Player player, String tag) throws NotRegisteredException {
        Resident resident = TownyAPI.getInstance().getResident(player);
        if (player != null && tag != null) {
            assert resident != null;
            try {
                return tag.contains("flagId:\"" + resident.getTown().getUUID().toString() + "\"");

            } catch (NotRegisteredException ignored) {

            }
        } else {
            throw new NullPointerException("again this null ?");
        }
        return false;
    }

}
