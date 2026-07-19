package dev.matthiesen.cobblemon_tablet.common.item;

import dev.matthiesen.cobblemon_tablet.common.CobblemonTabletCommon;
import dev.matthiesen.cobblemon_tablet.common.utility.PlayerUtils;
import io.wispforest.accessories.Accessories;
import io.wispforest.accessories.impl.PlayerEquipControl;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class TabletItem extends Item {
    public TabletItem() {
        super(new Item.Properties().stacksTo(1));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        PlayerUtils.openPC(player);
        return InteractionResultHolder.sidedSuccess(player.getItemInHand(interactionHand), level.isClientSide);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull TooltipContext tooltipContext, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        List<Component> lines = new ArrayList<>();
        lines.add(Component.empty()); // Add a blank line

        Component keybindComponent = Component.keybind("key.cobblemon_tablet.open_pc_tablet").withStyle(ChatFormatting.AQUA);
        lines.add(Component.translatable("item.cobblemon_tablet.pc_tablet.tooltip.keybind", keybindComponent).withStyle(ChatFormatting.GRAY));

        Component rightClick;

        if (CobblemonTabletCommon.INSTANCE.isModLoaded("accessories")) {
            var equipControl = Accessories.config().clientOptions.equipControl();
            if (Objects.requireNonNull(equipControl) == PlayerEquipControl.MUST_NOT_CROUCH) {
                rightClick = Component.empty()
                        .append(Component.keybind("key.sneak"))
                        .append(Component.literal(" + "))
                        .append(Component.translatable("item.cobblemon_tablet.pc_tablet.tooltip.right-click"))
                        .withStyle(ChatFormatting.AQUA);
            } else {
                rightClick = Component.translatable("item.cobblemon_tablet.pc_tablet.tooltip.right-click").withStyle(ChatFormatting.AQUA);
            }
        } else {
            rightClick = Component.translatable("item.cobblemon_tablet.pc_tablet.tooltip.right-click").withStyle(ChatFormatting.AQUA);
        }

        lines.add(Component.translatable("item.cobblemon_tablet.pc_tablet.tooltip.right-click.p1", rightClick).withStyle(ChatFormatting.GRAY));
        lines.add(Component.translatable("item.cobblemon_tablet.pc_tablet.tooltip.right-click.p2").withStyle(ChatFormatting.GRAY));

        tooltipComponents.addAll(lines);
    }
}
