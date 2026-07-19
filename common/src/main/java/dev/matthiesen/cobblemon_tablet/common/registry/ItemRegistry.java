package dev.matthiesen.cobblemon_tablet.common.registry;

import dev.matthiesen.cobblemon_tablet.common.CobblemonTabletCommon;
import dev.matthiesen.cobblemon_tablet.common.item.PCTabletItem;
import dev.matthiesen.common.matthiesen_lib.registry.AbstractItemRegistry;

import java.util.function.Supplier;

public final class ItemRegistry extends AbstractItemRegistry {
    public static final ItemRegistry INSTANCE = new ItemRegistry();

    private ItemRegistry() {
        super(CobblemonTabletCommon.MOD_ID);
    }

    public static void init() {
    }

    public static final Supplier<PCTabletItem> PC_TABLET_ITEM;

    static {
        PC_TABLET_ITEM = INSTANCE.register("pc_tablet", PCTabletItem::new);
    }
}
