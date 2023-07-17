package net.todobek.terrapotions.effect;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.PlayerModelPart;

public class LifeforceEffect extends MobEffect {

    private boolean applied = false;

    public LifeforceEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        super.applyEffectTick(pLivingEntity, pAmplifier);

        if(!applied) {
            double maxHealth = pLivingEntity.getAttribute(Attributes.MAX_HEALTH).getValue();
            double newHealth = maxHealth * 1.4;

            pLivingEntity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(newHealth);

            applied = true;
        }
    }

    @Override
    public void removeAttributeModifiers(LivingEntity pLivingEntity, AttributeMap pAttributeMap, int pAmplifier) {
        super.removeAttributeModifiers(pLivingEntity, pAttributeMap, pAmplifier);

        if(applied) {
            double maxHealth = pLivingEntity.getAttribute(Attributes.MAX_HEALTH).getValue();
            double newHealth = maxHealth / 1.4;

            pLivingEntity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(newHealth);

            applied = false;
        }

    }

    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
