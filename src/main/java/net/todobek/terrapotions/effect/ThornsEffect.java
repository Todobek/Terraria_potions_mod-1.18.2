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

    private boolean canDamage = true;
    private int cooldownTicks = 20;
    public ThornsEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        super.applyEffectTick(pLivingEntity, pAmplifier);


        if(pLivingEntity.getLastDamageSource() instanceof EntityDamageSource && canDamage) {
            Entity entity = pLivingEntity.getLastDamageSource().getEntity();

            if(entity != pLivingEntity) {
                entity.hurt(DamageSource.thorns(pLivingEntity), 3.0F);
                canDamage = false;
            }
        }
    }


    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {

        if (pDuration % cooldownTicks == 0) {
            canDamage = true;
        }
        return true;
    }
}
