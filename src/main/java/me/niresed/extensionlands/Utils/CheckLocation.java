package me.niresed.extensionlands.Utils;

import me.angeschossen.lands.api.LandsIntegration;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.Chunk;
import org.bukkit.Location;

import java.util.Objects;

public class CheckLocation {
    public static boolean checkTheArea (Location location, LandsIntegration api, LandPlayer player) {
        Chunk chunk = location.getChunk();
        Land land = api.getLandByChunk(chunk.getWorld(), chunk.getX(), chunk.getZ());
        int x = -3;
        int z = -3;
        boolean check = false;
        for (int i = 0; i <= 6; i++) {
            for (int s = 0; s <= 6; s++){
                if (Objects.equals(api.getLandByChunk(chunk.getWorld(), chunk.getX() + x, chunk.getZ() + z), player.getOwningLand())) {
                    if ((x >= -1 && x <= 1 && z >= -1 && z <= 1) && (x != 0 || z != 0)){
                        check = true;
                    }
                } else if (api.getLandByChunk(chunk.getWorld(), chunk.getX() + x, chunk.getZ() + z) != null) {
                    return false;
                }
                z += 1;
            }
            x += 1;
            z = -3;
        }
        return check;
    }
}
