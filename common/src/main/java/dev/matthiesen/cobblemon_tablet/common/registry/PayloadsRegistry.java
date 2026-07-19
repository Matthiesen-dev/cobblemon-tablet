package dev.matthiesen.cobblemon_tablet.common.registry;

import dev.matthiesen.cobblemon_tablet.common.CobblemonTabletCommon;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jetbrains.annotations.NotNull;

public final class PayloadsRegistry {
    public static OpenPcPayload openPC() {
        return new OpenPcPayload();
    }

    public record OpenPcPayload() implements CustomPacketPayload {
        public static final Type<OpenPcPayload> TYPE = new Type<>(CobblemonTabletCommon.modResource("open_pc_tablet"));
        public static final StreamCodec<RegistryFriendlyByteBuf, OpenPcPayload> CODEC = StreamCodec.unit(new OpenPcPayload());

        @Override
        public @NotNull Type<? extends CustomPacketPayload> type() {
            return TYPE;
        }
    }
}
