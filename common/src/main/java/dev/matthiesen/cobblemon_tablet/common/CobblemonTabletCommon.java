package dev.matthiesen.cobblemon_tablet.common;

import dev.matthiesen.cobblemon_tablet.common.accessories.AccessoriesCompat;
import dev.matthiesen.cobblemon_tablet.common.registry.NetworkingRegistry;
import dev.matthiesen.cobblemon_tablet.common.registry.CreativeModeTabRegistry;
import dev.matthiesen.cobblemon_tablet.common.registry.ItemRegistry;
import dev.matthiesen.libs.faststats.Token;
import dev.matthiesen.matthiesen_core.common.AbstractCommonMod;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public final class CobblemonTabletCommon extends AbstractCommonMod {
    public static final String MOD_ID = "cobblemon_tablet";
    public static final String MOD_NAME = "Cobblemon Tablet";
    public static @Token final String METRICS_TOKEN = "449c756e384ffac6ed88dd4d3de2f473";
    public static final String ACCESSORIES_MOD_ID = "accessories";

    public static final CobblemonTabletCommon INSTANCE = new CobblemonTabletCommon();

    public static boolean isAccessoriesLoaded() {
        return INSTANCE.getCommonUtils().isModLoaded(ACCESSORIES_MOD_ID);
    }

    public static ResourceLocation modResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    public CobblemonTabletCommon() {
        super(MOD_ID, MOD_NAME);
    }

    public void initialize() {
        super.initialize();
        ItemRegistry.init();
        CreativeModeTabRegistry.init();
        NetworkingRegistry.init();

        if (isAccessoriesLoaded()) {
            createInfoLog("Accessories mod detected, initializing compatibility");
            AccessoriesCompat.init();
        }

        createInfoLog("Initialized");
    }

    @Override
    public @Token @NotNull String getMetricsToken() {
        return METRICS_TOKEN;
    }
}
