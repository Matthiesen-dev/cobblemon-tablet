package dev.matthiesen.cobblemon_tablet.fabric;

import dev.matthiesen.cobblemon_tablet.common.CobblemonTabletCommonClient;
import dev.matthiesen.cobblemon_tablet.common.registry.payloads.OpenPcPayload;
import dev.matthiesen.common.matthiesen_lib.MatthiesenLib;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;

public class CobblemonTabletFabricClient implements ClientModInitializer {
    public static KeyMapping openPcKey;

    @Override
    public void onInitializeClient() {
        var instance = CobblemonTabletCommonClient.INSTANCE;
        instance.initialize();

        openPcKey = KeyBindingHelper.registerKeyBinding(CobblemonTabletCommonClient.OPEN_PC_KEYBIND);

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null) {
                while (openPcKey.consumeClick()) {
                    MatthiesenLib.networkingUtils.sendToServer(new OpenPcPayload());
                }
            }
        });
    }
}
