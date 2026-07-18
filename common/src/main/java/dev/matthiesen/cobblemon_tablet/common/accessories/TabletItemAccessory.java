package dev.matthiesen.cobblemon_tablet.common.accessories;

import dev.matthiesen.cobblemon_tablet.common.item.TabletItem;
import io.wispforest.accessories.api.Accessory;
import net.minecraft.world.item.ItemStack;

public record TabletItemAccessory<T extends TabletItem>(T item) implements Accessory {
    public boolean canEquipFromUse(ItemStack stack) {
        return false;
    }
}
