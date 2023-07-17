package net.todobek.terrapotions.effect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class ThornsEffect extends MobEffect {

    private boolean notAttacked;
    public ThornsEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        super.applyEffectTick(pLivingEntity, pAmplifier);

        notAttacked = true;

        if(pLivingEntity.getLastDamageSource() instanceof EntityDamageSource) {
            if(notAttacked) {
                Entity entity = pLivingEntity.getLastDamageSource().getEntity();
                entity.hurt(DamageSource.thorns(pLivingEntity), 1.0F);
                notAttacked = false;
            }
        }

    }

    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
