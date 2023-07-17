package net.todobek.terrapotions.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class TitanEffect extends MobEffect {

    private boolean applied = false;
    public TitanEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }



    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        super.applyEffectTick(pLivingEntity, pAmplifier);

        if(!applied) {
            double newKnockback = pLivingEntity.getAttribute(Attributes.ATTACK_KNOCKBACK).getValue() + 2.0;



            pLivingEntity.getAttribute(Attributes.ATTACK_KNOCKBACK).setBaseValue(newKnockback);

            applied = true;
        }

    }

    @Override
    public void removeAttributeModifiers(LivingEntity pLivingEntity, AttributeMap pAttributeMap, int pAmplifier) {
        super.removeAttributeModifiers(pLivingEntity,pAttributeMap, pAmplifier);

        if(applied) {

            double newKnockback = pLivingEntity.getAttribute(Attributes.ATTACK_KNOCKBACK).getValue() - 2.0;
            pLivingEntity.getAttribute(Attributes.ATTACK_KNOCKBACK).setBaseValue(newKnockback);

            applied = false;
        }
    }

    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
