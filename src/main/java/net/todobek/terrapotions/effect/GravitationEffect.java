package net.todobek.terrapotions.effect;

import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.lwjgl.glfw.GLFW;


public class GravitationEffect extends MobEffect {
    public GravitationEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    private static final float GRAVITY_MULTIPLIER = 0.0075f;

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

        if (pLivingEntity.isOnGround()) {
            boolean isGoingUp = pLivingEntity.getDeltaMovement().y > 0;

            if (pLivingEntity.isShiftKeyDown()) {
                if (isGoingUp) {
                    pLivingEntity.setDeltaMovement(pLivingEntity.getDeltaMovement().multiply(1, 1, -GRAVITY_MULTIPLIER));
                } else {
                    pLivingEntity.setDeltaMovement(pLivingEntity.getDeltaMovement().multiply(1, 1, GRAVITY_MULTIPLIER));
                }
            }
        }

        }
        @Override
        public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

}
