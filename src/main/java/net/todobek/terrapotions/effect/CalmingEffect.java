package net.todobek.terrapotions.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class CalmingEffect extends MobEffect {
    public CalmingEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    public void applyEffectTick(LivingEntity pLivingEntity, AttributeModifier attributeMap, int pAmplifier) {


        super.applyEffectTick(pLivingEntity, pAmplifier);
    }
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

}
