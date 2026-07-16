package dev.matthiesen.cobblemon_tablet.common.registry;

import dev.matthiesen.cobblemon_tablet.common.CobblemonTabletCommon;
import dev.matthiesen.cobblemon_tablet.common.item.TabletItem;
import dev.matthiesen.common.matthiesen_lib.registry.AbstractItemRegistry;

import java.util.function.Supplier;

public final class ItemRegistry extends AbstractItemRegistry {
    public static final ItemRegistry INSTANCE = new ItemRegistry();

    private ItemRegistry() {
        super(CobblemonTabletCommon.MOD_ID);
    }

    public static void init() {
    }

    public static final Supplier<TabletItem> TABLET_ITEM;

    static {
        TABLET_ITEM = INSTANCE.register("tablet", TabletItem::new);
    }
}
