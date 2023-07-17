package net.todobek.terrapotions.effect;

import net.minecraft.core.AxisCycle;
import net.minecraft.core.Direction;
import net.minecraft.util.datafix.fixes.ChunkPalettedStorageFix;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.levelgen.structure.templatesystem.AxisAlignedLinearPosTest;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.todobek.terrapotions.TerraPotions;

@Mod.EventBusSubscriber(modid = "terrapotions")
public class InfernoEffect extends MobEffect {
    public InfernoEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @SubscribeEvent
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        super.applyEffectTick(pLivingEntity, pAmplifier);
        if(pLivingEntity instanceof Player){
            AABB area = pLivingEntity.getBoundingBox().inflate(4);
            for(LivingEntity nearbyEntity : pLivingEntity.level.getEntitiesOfClass(LivingEntity.class, area)) {
                if(nearbyEntity instanceof Player) {
                    continue;
                }
                if(!nearbyEntity.isOnFire()) {
                    nearbyEntity.setSecondsOnFire(1);
                }

            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

}
