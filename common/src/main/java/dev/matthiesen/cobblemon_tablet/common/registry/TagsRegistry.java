package dev.matthiesen.cobblemon_tablet.common.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public final class TagsRegistry {
    public static final TagKey<Item> TABLETS = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("cobblemon_tablet", "tablets"));
}
