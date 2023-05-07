package me.niresed.extensionlands.Blocks;

import me.angeschossen.lands.api.LandsIntegration;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
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
        LandsIntegration api = LandsIntegration.of(ExtensionLands.getPlugin(ExtensionLands.class));

        LandPlayer landPlayer = api.getLandPlayer(player.getUniqueId());

        if (landPlayer == null){
            player.sendMessage(ChatColor.RED + plugin.getConfig().getString("land player error"));
            throw new NullPointerException(String.format("LandPlayer not found for player %s%n", player.getName()));
        }

        Land land = landPlayer.getOwningLand();

        if (land == null) {
            player.sendMessage(ChatColor.RED + plugin.getConfig().getString("player hasn't city"));
            return null;
        }

        ItemStack extensionFlag = new ItemStack(Material.BLACK_BANNER);

        net.minecraft.server.v1_16_R3.ItemStack assCopyExtensionFlag = CraftItemStack.asNMSCopy(extensionFlag);

        NBTTagCompound assExtensionFlagTag = new NBTTagCompound();

        assExtensionFlagTag.setBoolean("flagData", true);
        assExtensionFlagTag.setInt("flagDataOfLandId", land.getId());
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
        Plugin plugin = ExtensionLands.getPlugin(ExtensionLands.class);
        ItemStack item = generateFlag(player, plugin);

        if (item != null && isInventoryFull(player)) {
            player.getInventory().addItem(item);
            Bukkit.getLogger().info(player.getInventory().addItem(item).toString());
            return;
        }
        player.sendMessage("");
    }

    private static boolean isInventoryFull(Player player) {
        int emp = player.getInventory().firstEmpty();
        return (emp != -1);
    }

    public static boolean hasFlagDataOfLandId(LandPlayer landPlayer, String tag) {
        if (landPlayer != null && tag != null) {
            return tag.contains("flagDataOfLandId:" + Objects.requireNonNull(landPlayer.getOwningLand()).getId());

        } else {
            throw new NullPointerException("опять null ?");
        }
    }

}
