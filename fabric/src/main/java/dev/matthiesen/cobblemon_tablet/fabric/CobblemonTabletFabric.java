package dev.matthiesen.cobblemon_tablet.fabric;

import dev.matthiesen.cobblemon_tablet.common.CobblemonTabletCommon;
import net.fabricmc.api.ModInitializer;

public final class CobblemonTabletFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        var instance = CobblemonTabletCommon.INSTANCE;
        instance.createInfoLog("Loading for Fabric Mod Loader");
        instance.initialize();
    }
}
