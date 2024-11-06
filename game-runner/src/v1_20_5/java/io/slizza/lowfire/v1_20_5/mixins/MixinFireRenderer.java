package io.slizza.lowfire.v1_20_5.mixins;

import com.mojang.blaze3d.vertex.PoseStack;
import io.slizza.lowfire.LowFireAddon;
import io.slizza.lowfire.LowFireConfiguration;
import io.slizza.lowfire.utils.OffsetCalc;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ScreenEffectRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ScreenEffectRenderer.class)
public abstract class MixinFireRenderer {

  @Inject(method = "renderFire",
      at = @At(value = "INVOKE", target="Lcom/mojang/blaze3d/vertex/PoseStack;translate(FFF)V"))

  private static void onRenderFireOverlay(Minecraft client, PoseStack matrices, CallbackInfo ci) {
    LowFireConfiguration config = LowFireAddon.get().configuration();

    if(!config.enabled().get()) return;

    matrices.translate(0.0, OffsetCalc.calculateFireOffset(config.getFireSize().get()), 0.0);
  }
}
