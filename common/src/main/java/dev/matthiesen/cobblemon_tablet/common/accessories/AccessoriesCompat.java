package dev.matthiesen.cobblemon_tablet.common.accessories;

import dev.matthiesen.cobblemon_tablet.common.CobblemonTabletCommon;
import dev.matthiesen.cobblemon_tablet.common.item.PCTabletItem;
import io.wispforest.accessories.api.AccessoriesAPI;

public final class AccessoriesCompat {
    public static void init() {
        CobblemonTabletCommon.INSTANCE.getCommonRegistry().registerItemRegistryCallback(item -> {
            if (item instanceof PCTabletItem pcTabletItem) {
                AccessoriesAPI.registerAccessory(item, new PCTabletItemAccessory<>(pcTabletItem));
            }
        });
    }
}
