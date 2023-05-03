package me.niresed.extensionlands.Blocks;

import me.angeschossen.lands.api.LandsIntegration;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import me.niresed.extensionlands.Main.ExtensionLands;
import me.niresed.extensionlands.Utils.CheckLocation;
import net.kyori.adventure.text.Component;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class FlagData {
    public static ItemStack generateExtensionFlag(Player player){
        LandsIntegration api = LandsIntegration.of(ExtensionLands.getPlugin(ExtensionLands.class));

        LandPlayer landPlayer = api.getLandPlayer(player.getUniqueId());
        if (landPlayer == null){
            player.sendMessage(ChatColor.RED + "Error \"LandPlayer is null\"");
            return null;
        }

        Land land = landPlayer.getOwningLand();

        if (land == null) {
            player.sendMessage(ChatColor.RED + "You haven't land !");
            return null;
        }

        ItemStack extensionFlag = new ItemStack(Material.BLACK_BANNER);

        net.minecraft.server.v1_16_R3.ItemStack assCopyExtensionFlag = CraftItemStack.asNMSCopy(extensionFlag);

        NBTTagCompound assExtensionFlagTag = new NBTTagCompound();

        assExtensionFlagTag.setBoolean("flagData", true);
        assExtensionFlagTag.setInt("flagDataOfLandId", land.getId());

        assCopyExtensionFlag.setTag(assExtensionFlagTag);

        extensionFlag = CraftItemStack.asBukkitCopy(assCopyExtensionFlag);

        ItemMeta extensionFlagMeta = extensionFlag.getItemMeta();
        extensionFlagMeta.setCustomModelData(4324);
        extensionFlagMeta.displayName(Component.text("Land expansion flag"));
        extensionFlag.setItemMeta(extensionFlagMeta);

        return extensionFlag;
    }

    public static Boolean hasFlagData(ItemStack item, Player player, String tag, Block block){
        if (item != null){
            LandsIntegration api = LandsIntegration.of(ExtensionLands.getPlugin(ExtensionLands.class));
            LandPlayer landPlayer = api.getLandPlayer(player.getUniqueId());
            if (landPlayer == null) return null;

            Land land = landPlayer.getOwningLand();
            if (land == null) return null;

            if (tag.contains("flagDataOfLandId:" + Objects.requireNonNull(landPlayer.getOwningLand()).getId())) {
                Location location = block.getLocation();
                return CheckLocation.checkTheArea(location, api, landPlayer);
            }
        } else {
            throw new NullPointerException("опять null ?");
        }
        return false;
    }
}
