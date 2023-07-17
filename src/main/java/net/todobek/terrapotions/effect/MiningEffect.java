package net.todobek.terrapotions.effect;

import com.mojang.blaze3d.shaders.Effect;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class MiningEffect extends MobEffect {
    public MiningEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        super.applyEffectTick(pLivingEntity, pAmplifier);
        int hasteDuration = 20;
        int hasteLevel = 2;
        pLivingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, hasteDuration, hasteLevel));
    }

    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

}
