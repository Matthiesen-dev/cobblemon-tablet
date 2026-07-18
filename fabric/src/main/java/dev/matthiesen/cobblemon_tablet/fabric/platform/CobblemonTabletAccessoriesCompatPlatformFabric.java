package dev.matthiesen.cobblemon_tablet.fabric.platform;

import dev.matthiesen.cobblemon_tablet.common.platform.CobblemonTabletAccessoriesCompatPlatform;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

import java.util.function.Consumer;

public final class CobblemonTabletAccessoriesCompatPlatformFabric implements CobblemonTabletAccessoriesCompatPlatform {
    @Override
    public void addItemRegistryCallback(Consumer<Item> consumer) {
        RegistryEntryAddedCallback.event(BuiltInRegistries.ITEM)
                .register((i, resourceLocation, item) -> consumer.accept(item));
    }
}
