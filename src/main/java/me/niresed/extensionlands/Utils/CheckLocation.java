package me.niresed.extensionlands.Utils;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownBlock;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class CheckLocation {

    public static Boolean checkTheArea(Location location, Plugin plugin, Player player) {
        int x = -3;
        int z = -3;
        boolean check = false;
        Town town;
        for (int i = 0; i <= 6; i++) {

            for (int s = 0; s <= 6; s++) {

                Location slocation = new Location(location.getWorld(), location.getX() + x, 0, location.getZ() + z);
                town = TownyAPI.getInstance().getTown(slocation);

                if (town != null && !Objects.equals(town, TownyAPI.getInstance().getTown(player))) {
                    Bukkit.getLogger().info(ChatColor.RED + plugin.getConfig().getString("flag raised next to other city"));
                    return null;

                } else if (Objects.equals(town, TownyAPI.getInstance().getTown(player)) && (x == 0 && z == 0)) {
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
