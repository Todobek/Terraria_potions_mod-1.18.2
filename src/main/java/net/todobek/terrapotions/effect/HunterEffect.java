package net.todobek.terrapotions.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class HunterEffect extends MobEffect {
    public HunterEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @SubscribeEvent
    public void applyEffectTick(LivingEntity pLivingEntity,  int pAmplifier) {
        super.applyEffectTick(pLivingEntity, pAmplifier);
        if(pLivingEntity instanceof Player) {
            AABB area = pLivingEntity.getBoundingBox().inflate(35);
            for(LivingEntity nearbyEntity : pLivingEntity.level.getEntitiesOfClass(LivingEntity.class, area)) {
                if(nearbyEntity instanceof Player) {
                    continue;
                }
                if(!nearbyEntity.isOnFire()) {
                    nearbyEntity.addEffect(new net.minecraft.world.effect.MobEffectInstance(MobEffects.GLOWING, 100,
                            0, true, true));
                }

            }
        }
    }

    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
    }

