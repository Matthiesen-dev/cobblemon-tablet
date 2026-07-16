package dev.matthiesen.cobblemon_tablet.common;

import dev.matthiesen.common.matthiesen_lib_api.MatthiesenLibApi;
import dev.matthiesen.common.matthiesen_lib_api.abstracts.AbstractCommonMod;
import dev.matthiesen.libs.faststats.Token;
import org.jetbrains.annotations.Nullable;

public class CobblemonTabletCommon extends AbstractCommonMod {
    public static final String MOD_ID = "cobblemon_tablet";
    public static final String MOD_NAME = "Cobblemon Tablet";
    public static @Token final String METRICS_TOKEN = "";

    public static final CobblemonTabletCommon INSTANCE = new CobblemonTabletCommon();

    public CobblemonTabletCommon() {
        super(MOD_ID, MOD_NAME);
    }

    @Override
    public @Nullable @Token String getMetricsToken() {
        return METRICS_TOKEN;
    }

    @Override
    public Runnable reload() {
        return () -> {
            // TODO
            createInfoLog("Reloaded");
        };
    }

    public void initialize() {
        super.initialize();

       if (MatthiesenLibApi.isModLoaded("cobblemon")) {
            createInfoLog("Cobblemon is loaded, Hello there Cobblemon!");
       }

        createInfoLog("Initialized");
    }
}
