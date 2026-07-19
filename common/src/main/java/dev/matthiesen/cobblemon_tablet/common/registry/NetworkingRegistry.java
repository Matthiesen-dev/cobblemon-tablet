package dev.matthiesen.cobblemon_tablet.common.registry;

import dev.matthiesen.cobblemon_tablet.common.CobblemonTabletCommon;
import dev.matthiesen.cobblemon_tablet.common.utility.PlayerUtils;
import dev.matthiesen.common.matthiesen_lib.MatthiesenLib;
import dev.matthiesen.common.matthiesen_lib.core.network.PacketContext;
import io.wispforest.accessories.api.AccessoriesCapability;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public final class NetworkingRegistry {
    public static void init() {
        MatthiesenLib.networkingUtils.registerC2S(PayloadsRegistry.OpenPcPayload.TYPE, PayloadsRegistry.OpenPcPayload.CODEC, NetworkingRegistry::openPcC2S);
    }

    public static void openPcC2S(PayloadsRegistry.OpenPcPayload payload, PacketContext context) {
        if (context.player() instanceof ServerPlayer player) {
            // PC Tablet check
            if (isPlayerHoldingItem(player, ItemRegistry.PC_TABLET_ITEM)) {
                PlayerUtils.openPC(player);
            }
        }
    }

    public static boolean isPlayerHoldingItem(ServerPlayer player, Supplier<? extends Item> itemSupplier) {
        return isItemInInventory(player, itemSupplier) || isItemInAccessorySlot(player, itemSupplier);
    }

    public static boolean isItemInInventory(ServerPlayer player, Supplier<? extends Item> itemSupplier) {
        return player.getInventory().contains(stack -> !stack.isEmpty() && stack.is(itemSupplier.get()));
    }

    public static boolean isItemInAccessorySlot(ServerPlayer player, Supplier<? extends Item> itemSupplier) {
        if (CobblemonTabletCommon.isAccessoriesLoaded()) {
            var capability = AccessoriesCapability.get(player);
            if (capability != null) {
                return capability.isEquipped(stack -> !stack.isEmpty() && stack.is(itemSupplier.get()));
            }
        }
        return false;
    }
}
