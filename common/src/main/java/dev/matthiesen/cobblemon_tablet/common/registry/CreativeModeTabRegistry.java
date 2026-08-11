package dev.matthiesen.cobblemon_tablet.common.registry;

import dev.matthiesen.cobblemon_tablet.common.CobblemonTabletCommon;
import dev.matthiesen.matthiesen_core.common.registry.AbstractCreativeModeTabRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.function.Supplier;

public final class CreativeModeTabRegistry extends AbstractCreativeModeTabRegistry {
    public static final CreativeModeTabRegistry INSTANCE = new CreativeModeTabRegistry();

    private CreativeModeTabRegistry() {
        super(CobblemonTabletCommon.MOD_ID);
    }

    public static void init() {
        INSTANCE.registerTabAugmentation(
                CreativeModeTabs.TOOLS_AND_UTILITIES,
                () -> ItemRegistry.PC_TABLET_ITEM.get().getDefaultInstance()
        );
    }

    public static final Supplier<CreativeModeTab> TABLET_TAB;

    static {
        TABLET_TAB = INSTANCE.registerSimpleCreativeTab(
                "cobblemon_tablet_tab",
                Component.translatable("itemGroup.cobblemon_tablet.cobblemon_tablet_tab_title"),
                () -> new ItemStack(ItemRegistry.PC_TABLET_ITEM.get()),
                () -> List.of(new ItemStack(ItemRegistry.PC_TABLET_ITEM.get()))
        );
    }
}
