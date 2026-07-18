package dev.matthiesen.cobblemon_tablet.common.registry;

import dev.matthiesen.cobblemon_tablet.common.registry.payloads.OpenPcPayload;
import dev.matthiesen.cobblemon_tablet.common.utility.PlayerUtils;
import dev.matthiesen.common.matthiesen_lib.MatthiesenLib;
import dev.matthiesen.common.matthiesen_lib.core.network.PacketContext;
import net.minecraft.server.level.ServerPlayer;

public final class NetworkingRegistry {
    public static void init() {
        MatthiesenLib.networkingUtils.registerC2S(OpenPcPayload.TYPE, OpenPcPayload.CODEC, NetworkingRegistry::openPcC2S);
    }

    public static void openPcC2S(OpenPcPayload payload, PacketContext context) {
        if (context.player() instanceof ServerPlayer player) {
            if (player.getInventory().contains(ItemRegistry.TABLET_ITEM.get().getDefaultInstance())) {
                PlayerUtils.openPC(player);
            }
        }
    }
}
