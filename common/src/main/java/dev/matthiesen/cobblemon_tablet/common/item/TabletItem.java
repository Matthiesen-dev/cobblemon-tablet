package dev.matthiesen.cobblemon_tablet.common.item;

import com.cobblemon.mod.common.Cobblemon;
import com.cobblemon.mod.common.CobblemonSounds;
import com.cobblemon.mod.common.api.storage.pc.PCStore;
import com.cobblemon.mod.common.api.storage.pc.link.PCLink;
import com.cobblemon.mod.common.api.storage.pc.link.PCLinkManager;
import com.cobblemon.mod.common.net.messages.client.storage.pc.OpenPCPacket;
import com.cobblemon.mod.common.util.PlayerExtensionsKt;
import dev.matthiesen.cobblemon_tablet.common.CobblemonTabletCommon;
import dev.matthiesen.common.matthiesen_lib_api.utility.SoundsPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public final class TabletItem extends Item {
    public TabletItem() {
        super(new Item.Properties().stacksTo(1));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        openPC(player);
        return InteractionResultHolder.sidedSuccess(player.getItemInHand(interactionHand), level.isClientSide);
    }

    private static void openPC(Player player) {
        if (!(player instanceof ServerPlayer serverPlayer)) return;

        if (PlayerExtensionsKt.isInBattle(serverPlayer)) {
            serverPlayer.sendSystemMessage(Component.translatable("messages.cobblemon_tablet.error.in_battle").withStyle(net.minecraft.ChatFormatting.RED), true);
            return;
        }

        try {
            PCStore pc = Cobblemon.INSTANCE.getStorage().getPC(serverPlayer);
            PCLinkManager.INSTANCE.addLink(new PCLink(pc, serverPlayer.getUUID()));
            new SoundsPlayer(CobblemonSounds.PC_ON).play(serverPlayer);
            new OpenPCPacket(pc).sendToPlayer(serverPlayer);
        } catch (RuntimeException e) {
            CobblemonTabletCommon.INSTANCE.createErrorLog("Failed to open PC for player " + player.getName().getString() + ": " + e.getMessage(), e);
            serverPlayer.sendSystemMessage(Component.translatable("messages.cobblemon_tablet.error.failed_to_open_pc").withStyle(net.minecraft.ChatFormatting.RED), true);
        }
    }
}
