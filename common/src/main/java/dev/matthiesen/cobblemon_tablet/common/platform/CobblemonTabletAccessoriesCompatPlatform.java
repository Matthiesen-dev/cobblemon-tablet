package dev.matthiesen.cobblemon_tablet.common.platform;

import net.minecraft.world.item.Item;

import java.util.function.Consumer;

public interface CobblemonTabletAccessoriesCompatPlatform {
    void addItemRegistryCallback(Consumer<Item> consumer);
}
