package dev.matthiesen.cobblemon_tablet.common;

import com.mojang.blaze3d.platform.InputConstants;
import dev.matthiesen.cobblemon_tablet.common.registry.NetworkingRegistry;
import dev.matthiesen.matthiesen_core.common.AbstractCommonClientMod;
import dev.matthiesen.matthiesen_core.common.api.client.keybinds.KeybindMapping;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public final class CobblemonTabletCommonClient extends AbstractCommonClientMod {
    public static final CobblemonTabletCommonClient INSTANCE = new CobblemonTabletCommonClient();

    private CobblemonTabletCommonClient() {
        super(CobblemonTabletCommon.INSTANCE);
    }

    public static final KeyMapping OPEN_PC_KEYBIND;
    public static final KeybindMapping OPEN_PC_KEYBIND_MAPPING;

    static {
        OPEN_PC_KEYBIND = new KeyMapping(
                "key.cobblemon_tablet.open_pc_tablet",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_V,
                "category.cobblemon_tablet.title"
        );

        OPEN_PC_KEYBIND_MAPPING = new KeybindMapping() {
            @Override
            public KeyMapping getKeybind() {
                return OPEN_PC_KEYBIND;
            }

            @Override
            public void onClientTick() {
                while (OPEN_PC_KEYBIND.consumeClick()) {
                    CobblemonTabletCommon.INSTANCE.getNetworkingManager().sendToServer(new NetworkingRegistry.OpenPcPayload());
                }
            }
        };
    }

    @Override
    public void initialize() {
        createInfoLog("Loading client-side for " + CobblemonTabletCommon.MOD_NAME);
        INSTANCE.getKeybindingsManager().registerKeybind("cobblemon_tablet:open_pc_tablet", OPEN_PC_KEYBIND_MAPPING);
    }
}
