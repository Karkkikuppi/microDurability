package com.github.reviversmc.microdurability.mixin;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;

import com.github.reviversmc.microdurability.MicroDurability120;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin120 {
    @Inject(
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameHud;renderStatusBars(Lnet/minecraft/client/gui/DrawContext;)V"
            ),
            method = "render"
    )
    public void renderMicroDurability(DrawContext context, float tickDelta, CallbackInfo ci) {
        MicroDurability120.renderer.onHudRender(context.getMatrices(), tickDelta);
    }
}
