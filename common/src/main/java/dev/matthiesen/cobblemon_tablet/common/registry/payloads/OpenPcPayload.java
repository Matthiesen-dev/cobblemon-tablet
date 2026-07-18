package dev.matthiesen.cobblemon_tablet.common.registry.payloads;

import dev.matthiesen.cobblemon_tablet.common.CobblemonTabletCommon;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public record OpenPcPayload()  implements CustomPacketPayload {
    public static final Type<OpenPcPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(CobblemonTabletCommon.MOD_ID, "open_pc"));
    public static final StreamCodec<RegistryFriendlyByteBuf, OpenPcPayload> CODEC = StreamCodec.unit(new OpenPcPayload());

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
