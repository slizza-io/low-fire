package io.slizza.lowfire.v1_12_2.mixins;

import io.slizza.lowfire.LowFireAddon;
import io.slizza.lowfire.LowFireConfiguration;
import io.slizza.lowfire.utils.MathUtil;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemRenderer.class)
public abstract class MixinFireRenderer {

  @Inject(method = "renderFireInFirstPerson",
      at = @At(value = "INVOKE", target="Lnet/minecraft/client/renderer/GlStateManager;translate(FFF)V", ordinal = 0))

  private void onRenderFireOverlay(CallbackInfo ci) {
    LowFireConfiguration config = LowFireAddon.get().configuration();

    if(!config.enabled().get()) return;

    GlStateManager.translate(0.0, MathUtil.calculateFireOffset(config.getFireSize().get()), 0.0);
  }
}
