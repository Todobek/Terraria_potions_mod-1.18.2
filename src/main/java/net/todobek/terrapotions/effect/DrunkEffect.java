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
    private double armor;

    public DrunkEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }
    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        super.applyEffectTick(pLivingEntity, pAmplifier);

        if(!applied) {

            speed = pLivingEntity.getAttribute(Attributes.ATTACK_SPEED).getValue();
            armor = pLivingEntity.getArmorCoverPercentage();

            int damageDuration = 20;
            int damageLevel = 2;
            pLivingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, damageDuration, damageLevel));

            pLivingEntity.getAttribute(Attributes.ARMOR).setBaseValue(armor-4);
            pLivingEntity.getAttribute(Attributes.ATTACK_SPEED).setBaseValue(speed+4);

            applied = true;
        }
    }

    public void removeAttributeModifiers(LivingEntity pLivingEntity, AttributeMap pAttributeMap, int pAmplifier) {
        super.removeAttributeModifiers(pLivingEntity, pAttributeMap, pAmplifier);

        if(applied) {

            speed = pLivingEntity.getAttribute(Attributes.ATTACK_SPEED).getValue();
            armor = pLivingEntity.getArmorCoverPercentage();

            pLivingEntity.removeEffect(MobEffects.DAMAGE_BOOST);
            pLivingEntity.getAttribute(Attributes.ARMOR).setBaseValue(armor+4);
            pLivingEntity.getAttribute(Attributes.ATTACK_SPEED).setBaseValue(speed-4);

            applied = false;
        }
    }
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
