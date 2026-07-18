package dev.matthiesen.cobblemon_tablet.common.accessories;

import dev.matthiesen.cobblemon_tablet.common.item.TabletItem;
import io.wispforest.accessories.api.Accessory;

public record TabletItemAccessory<T extends TabletItem>(T item) implements Accessory {
}
