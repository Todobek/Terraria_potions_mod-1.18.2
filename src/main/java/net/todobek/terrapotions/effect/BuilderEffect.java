package net.todobek.terrapotions.effect;

import com.mojang.datafixers.types.templates.List;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.commands.arguments.NbtPathArgument;
import net.minecraft.commands.arguments.NbtTagArgument;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.extensions.IForgeMobEffect;
import net.minecraftforge.common.extensions.IForgeMobEffectInstance;
import net.minecraftforge.event.world.StructureSpawnListGatherEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class BuilderEffect extends MobEffect implements IForgeMobEffect {

    private boolean applied = false;
    public BuilderEffect(MobEffectCategory mobEffectCategory, int color) {

        super(mobEffectCategory, color);
    }


    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        super.applyEffectTick(pLivingEntity, pAmplifier);
        if(!applied) {
            if(pLivingEntity instanceof Player) {
                pLivingEntity.getAttribute(ForgeMod.REACH_DISTANCE.get()).setBaseValue(7.0);
            }
            applied = true;
        }
    }


    @Override
    public void removeAttributeModifiers(LivingEntity pLivingEntity, AttributeMap attributeMap, int pAmplifier) {
        super.removeAttributeModifiers(pLivingEntity, attributeMap, pAmplifier);
        if(applied) {
            if(pLivingEntity instanceof Player) {
                pLivingEntity.getAttribute(ForgeMod.REACH_DISTANCE.get()).setBaseValue(4.5);
            }
            applied = false;
        }
    }
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
