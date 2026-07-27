package dev.matthiesen.cobblemon_tablet.neoforge;

import dev.matthiesen.cobblemon_tablet.common.CobblemonTabletCommon;
import dev.matthiesen.cobblemon_tablet.common.CobblemonTabletCommonClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(value = CobblemonTabletCommon.MOD_ID, dist = Dist.CLIENT)
public final class CobblemonTabletNeoForgeClient {
    public static final CobblemonTabletCommonClient INSTANCE = CobblemonTabletCommonClient.INSTANCE;

    public CobblemonTabletNeoForgeClient(IEventBus modBus) {
        modBus.addListener(this::clientSetup);
    }

    public void clientSetup(FMLClientSetupEvent event) {
        INSTANCE.initialize();
    }
}
