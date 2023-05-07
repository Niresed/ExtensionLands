package me.niresed.extensionlands.Utils;

import me.angeschossen.lands.api.LandsIntegration;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class CheckLocation {

    public static Boolean checkTheArea(Location location, Plugin plugin, LandPlayer player) {
        LandsIntegration api = LandsIntegration.of(plugin);
        Chunk chunk = location.getChunk();
        int x = -3;
        int z = -3;
        boolean check = false;
        Land land;
        for (int i = 0; i <= 6; i++) {

            for (int s = 0; s <= 6; s++) {

                land = api.getLandByChunk(chunk.getWorld(), chunk.getX() + x, chunk.getZ() + z);

                if (land != null && !Objects.equals(land, player.getOwningLand())) {
                    Bukkit.getLogger().info(ChatColor.RED + plugin.getConfig().getString("flag raised next to other city"));
                    return null;

                } else if (Objects.equals(land, player.getOwningLand()) && (x == 0 && z == 0)) {
                    Bukkit.getLogger().info(ChatColor.RED + plugin.getConfig().getString("taken chunk"));
                    return null;

                } else {
                    if ((x == -1 || x == 1) && (z == -1 || z == 1)) {
                        Bukkit.getLogger().info("");
                        check = true;
                    }

                }

                z += 1;
            }

            x += 1;
            z = -3;
        }
        return check;
    }
}
