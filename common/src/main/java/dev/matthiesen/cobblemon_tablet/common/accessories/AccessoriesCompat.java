package dev.matthiesen.cobblemon_tablet.common.accessories;

import dev.matthiesen.cobblemon_tablet.common.item.TabletItem;
import dev.matthiesen.cobblemon_tablet.common.platform.CobblemonTabletAccessoriesCompatPlatform;
import io.wispforest.accessories.api.AccessoriesAPI;

import java.util.ServiceLoader;

public final class AccessoriesCompat {
    public static final CobblemonTabletAccessoriesCompatPlatform ACCESSORIES_COMPAT_PLATFORM =
            ServiceLoader.load(CobblemonTabletAccessoriesCompatPlatform.class).findFirst().orElseThrow();

    public static void init() {
        ACCESSORIES_COMPAT_PLATFORM.addItemRegistryCallback(item -> {
            if (item instanceof TabletItem tabletItem) {
                AccessoriesAPI.registerAccessory(item, new TabletItemAccessory<>(tabletItem));
            }
        });
    }
}
