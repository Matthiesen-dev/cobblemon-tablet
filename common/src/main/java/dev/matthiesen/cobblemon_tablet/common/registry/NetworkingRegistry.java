package dev.matthiesen.cobblemon_tablet.common.registry;

import dev.matthiesen.cobblemon_tablet.common.CobblemonTabletCommon;
import dev.matthiesen.cobblemon_tablet.common.utility.PlayerUtils;
import dev.matthiesen.common.matthiesen_lib.MatthiesenLib;
import dev.matthiesen.common.matthiesen_lib.core.network.PacketContext;
import io.wispforest.accessories.api.AccessoriesCapability;
import net.minecraft.server.level.ServerPlayer;

public final class NetworkingRegistry {
    public static void init() {
        MatthiesenLib.networkingUtils.registerC2S(PayloadsRegistry.OpenPcPayload.TYPE, PayloadsRegistry.OpenPcPayload.CODEC, NetworkingRegistry::openPcC2S);
    }

    public static void openPcC2S(PayloadsRegistry.OpenPcPayload payload, PacketContext context) {
        if (context.player() instanceof ServerPlayer player) {
            if (CobblemonTabletCommon.isAccessoriesLoaded()) {
                var capability = AccessoriesCapability.get(player);
                if (capability != null) {
                    if (capability.isEquipped(stack -> !stack.isEmpty() && stack.is(ItemRegistry.TABLET_ITEM.get()))) {
                        PlayerUtils.openPC(player);
                    }
                }
            }

            if (player.getInventory().contains(stack -> !stack.isEmpty() && stack.is(ItemRegistry.TABLET_ITEM.get()))) {
                PlayerUtils.openPC(player);
            }
        }
    }
}
