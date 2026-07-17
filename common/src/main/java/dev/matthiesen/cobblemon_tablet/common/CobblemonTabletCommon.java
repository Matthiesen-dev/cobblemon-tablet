package dev.matthiesen.cobblemon_tablet.common;

import dev.matthiesen.cobblemon_tablet.common.registry.CreativeModeTabRegistry;
import dev.matthiesen.cobblemon_tablet.common.registry.ItemRegistry;
import dev.matthiesen.common.matthiesen_lib_api.abstracts.AbstractCommonMod;
import dev.matthiesen.libs.faststats.Token;
import org.jetbrains.annotations.NotNull;

public final class CobblemonTabletCommon extends AbstractCommonMod {
    public static final String MOD_ID = "cobblemon_tablet";
    public static final String MOD_NAME = "Cobblemon Tablet";
    public static @Token final String METRICS_TOKEN = "449c756e384ffac6ed88dd4d3de2f473";

    public static final CobblemonTabletCommon INSTANCE = new CobblemonTabletCommon();

    public CobblemonTabletCommon() {
        super(MOD_ID, MOD_NAME);
    }

    public void initialize() {
        super.initialize();
        ItemRegistry.init();
        CreativeModeTabRegistry.init();

        createInfoLog("Initialized");
    }

    @Override
    public Runnable reload() {
        return () -> {
            // TODO
            createInfoLog("Reloaded");
        };
    }

    @Override
    public @Token @NotNull String getMetricsToken() {
        return METRICS_TOKEN;
    }
}
