package com.github.reviversmc.microdurability;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;

public class Renderer120 extends RendererBase {

    @Override
    protected void renderGuiQuad(BufferBuilder buffer, int x, int y, int width, int height, int red, int green,
            int blue, int alpha) {
        RenderSystem.setShader(GameRenderer::getPositionColorProgram);
        buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);
        buffer.vertex(x,         y,          0.0D).color(red, green, blue, alpha).next();
        buffer.vertex(x,         y + height, 0.0D).color(red, green, blue, alpha).next();
        buffer.vertex(x + width, y + height, 0.0D).color(red, green, blue, alpha).next();
        buffer.vertex(x + width, y,          0.0D).color(red, green, blue, alpha).next();
        BufferRenderer.drawWithGlobalProgram(buffer.end());
    }

    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {

    }
}
