package net.todobek.terrapotions.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class DrunkEffect extends MobEffect {

    private boolean applied = false;
    private double speed;
    private float armor;

    public DrunkEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }
    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        super.applyEffectTick(pLivingEntity, pAmplifier);
        int damageDuration = 20;
        int damageLevel = 2;
        pLivingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, damageDuration, damageLevel));

        if(!applied) {
            float x = pLivingEntity.getArmorCoverPercentage();
            double y = pLivingEntity.getAttribute(Attributes.ATTACK_SPEED).getValue();
            speed = y;
            armor = x;



            pLivingEntity.getAttribute(Attributes.ARMOR).setBaseValue(x-2);
            pLivingEntity.getAttribute(Attributes.ATTACK_SPEED).setBaseValue(y+6.0);
            applied = true;
        }
    }

    public void removeAttributeModifiers(LivingEntity pLivingEntity, AttributeMap pAttributeMap, int pAmplifier) {
        super.removeAttributeModifiers(pLivingEntity, pAttributeMap, pAmplifier);

        if(applied) {
            pLivingEntity.getAttribute(Attributes.ARMOR).setBaseValue(armor);
            pLivingEntity.getAttribute(Attributes.ATTACK_SPEED).setBaseValue(speed);

            applied = false;
        }
    }
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
