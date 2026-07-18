package dev.matthiesen.cobblemon_tablet.neoforge.platform;

import dev.matthiesen.cobblemon_tablet.common.platform.CobblemonTabletAccessoriesCompatPlatform;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.callback.AddCallback;

import java.util.function.Consumer;

public final class CobblemonTabletAccessoriesCompatPlatformNeoForge implements CobblemonTabletAccessoriesCompatPlatform {
    @Override
    public void addItemRegistryCallback(Consumer<Item> consumer) {
        BuiltInRegistries.ITEM.addCallback((AddCallback<Item>) (registry, i, key, item) -> consumer.accept(item));
    }
}
