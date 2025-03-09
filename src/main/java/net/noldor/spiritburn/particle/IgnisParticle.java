package net.noldor.spiritburn.particle;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.*;
import net.minecraft.client.render.*;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import org.jetbrains.annotations.Nullable;


import java.util.Random;

public class IgnisParticle extends SpriteBillboardParticle {

    private static final Random RANDOM = new Random();

    protected IgnisParticle(ClientWorld clientWorld, double x, double y, double z, SpriteProvider spriteProvider, double xSpeed, double ySpeed, double zSpeed) {
        super(clientWorld, x, y, z, xSpeed, ySpeed, zSpeed);
        this.setVelocity(xSpeed, ySpeed, zSpeed);
        this.scale *= 0.9f;
        this.gravityStrength = ySpeed != 0 && xSpeed != 0 && zSpeed != 0 ? -0.01F : 0F;
        this.velocityMultiplier = 0.999F;

        //color particle
        int hex = 0xF6B4D8;
        int r = (hex & 0xFF0000) >> 16;
        int g = (hex & 0xFF00) >> 8;
        int b = (hex & 0xFF);
        this.setColor(r/ 255f, g/ 255f, b/ 255f);
        this.setAlpha(0.3f);
        this.velocityMultiplier = 0.96f;
        this.gravityStrength = (velocityY != 0 && velocityX != 0 && velocityZ != 0) ? -0.01f : 0f;
        this.collidesWithWorld = true;

        this.angle = RANDOM.nextFloat(360);
        this.prevAngle = this.angle;

        this.maxAge = (int) (64.0 / ((Math.random() + 3f) * 0.25f));
        this.setSpriteForAge(spriteProvider);

    }
    public void tick() {
        super.tick();
        this.alpha = 1.0f - ((float) this.age / (float) this.maxAge);
        this.alpha *= 0.3f;
        this.scale *= 0.96f;
    }

    //Custom Render Type
    public static class IgnisRenderType implements ParticleTextureSheet {


        @Override
        public void begin(BufferBuilder builder, TextureManager textureManager) {

            MinecraftClient.getInstance().gameRenderer.getLightmapTextureManager().enable();

            // Включаем режим прозрачности и смешивания
            RenderSystem.depthMask(false);
            RenderSystem.enableBlend();
            RenderSystem.blendFunc(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE);

            // Указываем текстуру для частиц
            RenderSystem.setShaderTexture(0, SpriteAtlasTexture.PARTICLE_ATLAS_TEXTURE);

            // Получаем текстуру и применяем настройки фильтрации
            var texture = textureManager.getTexture(SpriteAtlasTexture.PARTICLE_ATLAS_TEXTURE);
            texture.setFilter(true, false);

            // Начинаем отрисовку частиц в режиме QUADS
            builder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
            RenderSystem.enableDepthTest();

        }

        @Override
        public void draw(Tessellator tessellator) {
            tessellator.draw();
            RenderSystem.disableBlend();
            RenderSystem.depthMask(true);

        }
        @Override
        public String toString() {
            return "IGNIS_PARTICLE";
        }
    }
    IgnisRenderType IGNIS_PARTICLE = new IgnisRenderType();


    @Override
    public ParticleTextureSheet getType() {
        return IGNIS_PARTICLE;
    }
    public static class Factory implements ParticleFactory<DefaultParticleType>{
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public @Nullable Particle createParticle(DefaultParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            return new IgnisParticle(world, x,y,z, this.spriteProvider, velocityX, velocityY, velocityZ);
        }
    }
}
