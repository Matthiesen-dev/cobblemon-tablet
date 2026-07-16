package dev.matthiesen.cobblemon_tablet.fabric;

import dev.matthiesen.cobblemon_tablet.common.CobblemonTabletCommonClient;
import net.fabricmc.api.ClientModInitializer;

public class CobblemonTabletFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CobblemonTabletCommonClient.initialize();
    }
}
