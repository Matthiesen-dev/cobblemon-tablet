package dev.matthiesen.cobblemon_tablet.neoforge;

import dev.matthiesen.cobblemon_tablet.common.CobblemonTabletCommon;
import dev.matthiesen.cobblemon_tablet.common.CobblemonTabletCommonClient;
import dev.matthiesen.cobblemon_tablet.common.registry.payloads.OpenPcPayload;
import dev.matthiesen.common.matthiesen_lib.MatthiesenLib;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;

@Mod(value = CobblemonTabletCommon.MOD_ID, dist = Dist.CLIENT)
public class CobblemonTabletNeoForgeClient {
    public static KeyMapping openPcKey;
    public static CobblemonTabletCommonClient INSTANCE;

    public CobblemonTabletNeoForgeClient(IEventBus modBus) {
        INSTANCE = CobblemonTabletCommonClient.INSTANCE;
        modBus.addListener(this::clientSetup);
        modBus.addListener(this::registerBindings);

        openPcKey = CobblemonTabletCommonClient.OPEN_PC_KEYBIND;
    }

    public void clientSetup(FMLClientSetupEvent event) {
        INSTANCE.initialize();
    }

    public void registerBindings(RegisterKeyMappingsEvent event) {
        event.register(openPcKey);
    }

    @EventBusSubscriber(modid = CobblemonTabletCommon.MOD_ID, value = Dist.CLIENT)
    public static class TickHandler {
        @SubscribeEvent
        public static void onClientTick(ClientTickEvent.Post event) {
            while(openPcKey.consumeClick()) {
                MatthiesenLib.networkingUtils.sendToServer(new OpenPcPayload());
            }
        }
    }

}
