package dev.matthiesen.cobblemon_tablet.neoforge;

import dev.matthiesen.cobblemon_tablet.common.CobblemonTabletCommon;
import net.neoforged.fml.common.Mod;

@Mod(CobblemonTabletCommon.MOD_ID)
public class CobblemonTabletNeoForge {
    public CobblemonTabletNeoForge() {
        var instance = CobblemonTabletCommon.INSTANCE;
        instance.createInfoLog("Loading for NeoForge Mod Loader");
        instance.initialize();
    }
}
