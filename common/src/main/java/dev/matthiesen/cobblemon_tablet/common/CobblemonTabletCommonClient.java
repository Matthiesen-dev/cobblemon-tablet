package dev.matthiesen.cobblemon_tablet.common;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public final class CobblemonTabletCommonClient {
    public static final KeyMapping OPEN_PC_KEYBIND;

    static {
        OPEN_PC_KEYBIND = new KeyMapping(
                "key.cobblemon_tablet.open_tablet_pc",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_P,
                "category.cobblemon_tablet.title"
        );
    }

    public static void initialize() {
        CobblemonTabletCommon.INSTANCE.createInfoLog("Loading client-side for " + CobblemonTabletCommon.MOD_NAME);
    }
}
