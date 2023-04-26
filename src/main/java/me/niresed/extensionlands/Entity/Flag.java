package me.niresed.extensionlands.Entity;

import com.destroystokyo.paper.block.BlockSoundGroup;
import net.kyori.adventure.text.Component;
import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pose;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Flag implements Block {
    private final Location location;
    public Flag(Location location){
        this.location = location;
    }
    @Override
    public byte getData() {
        return 0;
    }

    @Override
    public @NotNull BlockData getBlockData() {
        return null;
    }

    @Override
    public @NotNull Block getRelative(int modX, int modY, int modZ) {
        return null;
    }

    @Override
    public @NotNull Block getRelative(@NotNull BlockFace face) {
        return null;
    }

    @Override
    public @NotNull Block getRelative(@NotNull BlockFace face, int distance) {
        return null;
    }

    @Override
    public @NotNull Material getType() {
        return null;
    }

    @Override
    public byte getLightLevel() {
        return 0;
    }

    @Override
    public byte getLightFromSky() {
        return 0;
    }

    @Override
    public byte getLightFromBlocks() {
        return 0;
    }

    @Override
    public @NotNull World getWorld() {
        return null;
    }

    @Override
    public int getX() {
        return location.getBlockX();
    }

    @Override
    public int getY() {
        return location.getBlockY();
    }

    @Override
    public int getZ() {
        return location.getBlockZ();
    }

    @Override
    public boolean isValidTool(@NotNull ItemStack itemStack) {
        return false;
    }

    @Override
    public @NotNull Location getLocation() {
        return location;
    }

    @Override
    public @Nullable Location getLocation(@Nullable Location loc) {
        return null;
    }

    @Override
    public @NotNull Chunk getChunk() {
        return null;
    }

    @Override
    public void setBlockData(@NotNull BlockData data) {

    }

    @Override
    public void setBlockData(@NotNull BlockData data, boolean applyPhysics) {

    }

    @Override
    public void setType(@NotNull Material type) {

    }

    @Override
    public void setType(@NotNull Material type, boolean applyPhysics) {

    }

    @Override
    public @Nullable BlockFace getFace(@NotNull Block block) {
        return null;
    }

    @Override
    public @NotNull BlockState getState() {
        return null;
    }

    @Override
    public @NotNull BlockState getState(boolean useSnapshot) {
        return null;
    }

    @Override
    public @NotNull Biome getBiome() {
        return null;
    }

    @Override
    public void setBiome(@NotNull Biome bio) {

    }

    @Override
    public boolean isBlockPowered() {
        return false;
    }

    @Override
    public boolean isBlockIndirectlyPowered() {
        return false;
    }

    @Override
    public boolean isBlockFacePowered(@NotNull BlockFace face) {
        return false;
    }

    @Override
    public boolean isBlockFaceIndirectlyPowered(@NotNull BlockFace face) {
        return false;
    }

    @Override
    public int getBlockPower(@NotNull BlockFace face) {
        return 0;
    }

    @Override
    public int getBlockPower() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isLiquid() {
        return false;
    }

    @Override
    public boolean isBuildable() {
        return false;
    }

    @Override
    public boolean isBurnable() {
        return false;
    }

    @Override
    public boolean isReplaceable() {
        return false;
    }

    @Override
    public boolean isSolid() {
        return false;
    }

    @Override
    public double getTemperature() {
        return 0;
    }

    @Override
    public double getHumidity() {
        return 0;
    }

    @Override
    public @NotNull PistonMoveReaction getPistonMoveReaction() {
        return null;
    }

    @Override
    public boolean breakNaturally() {
        return false;
    }

    @Override
    public boolean breakNaturally(@Nullable ItemStack tool) {
        return false;
    }

    @Override
    public boolean breakNaturally(@NotNull ItemStack tool, boolean triggerEffect) {
        return false;
    }

    @Override
    public boolean applyBoneMeal(@NotNull BlockFace face) {
        return false;
    }

    @Override
    public @NotNull Collection<ItemStack> getDrops() {
        return null;
    }

    @Override
    public @NotNull Collection<ItemStack> getDrops(@Nullable ItemStack tool) {
        return null;
    }

    @Override
    public @NotNull Collection<ItemStack> getDrops(@NotNull ItemStack tool, @Nullable Entity entity) {
        return null;
    }

    @Override
    public boolean isPreferredTool(@NotNull ItemStack tool) {
        return false;
    }

    @Override
    public boolean isPassable() {
        return false;
    }

    @Override
    public @Nullable RayTraceResult rayTrace(@NotNull Location start, @NotNull Vector direction, double maxDistance, @NotNull FluidCollisionMode fluidCollisionMode) {
        return null;
    }

    @Override
    public @NotNull BoundingBox getBoundingBox() {
        return null;
    }

    @Override
    public @NotNull BlockSoundGroup getSoundGroup() {
        return null;
    }

    @Override
    public @NotNull String getTranslationKey() {
        return null;
    }

    @Override
    public @NotNull float getDestroySpeed(@NotNull ItemStack itemStack, boolean considerEnchants) {
        return 0;
    }

    @Override
    public void setMetadata(@NotNull String metadataKey, @NotNull MetadataValue newMetadataValue) {

    }

    @Override
    public @NotNull List<MetadataValue> getMetadata(@NotNull String metadataKey) {
        return null;
    }

    @Override
    public boolean hasMetadata(@NotNull String metadataKey) {
        return false;
    }

    @Override
    public void removeMetadata(@NotNull String metadataKey, @NotNull Plugin owningPlugin) {

    }
}
