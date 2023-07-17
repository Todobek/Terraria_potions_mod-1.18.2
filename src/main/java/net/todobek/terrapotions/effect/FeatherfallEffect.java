package net.todobek.terrapotions.effect;

import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class FeatherfallEffect extends MobEffect {
    public FeatherfallEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        super.applyEffectTick(pLivingEntity, pAmplifier);
        pLivingEntity.fallDistance = 0;
        pLivingEntity.setDeltaMovement(pLivingEntity.getDeltaMovement().get(Direction.Axis.X), -0.1,
                pLivingEntity.getDeltaMovement().get(Direction.Axis.Z));
    }

    public boolean isDurationEffectTick(int pDuration, int pAmplifier){
        return true;
    }

}
