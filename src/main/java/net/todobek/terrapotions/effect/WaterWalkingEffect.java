package net.todobek.terrapotions.effect;

import com.sun.jna.platform.unix.X11;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.world.WorldEvent;

import javax.xml.crypto.Data;

public class WaterWalkingEffect extends MobEffect {

    public WaterWalkingEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        super.applyEffectTick(pLivingEntity, pAmplifier);

        if(pLivingEntity.isInWater()) {
            BlockState state = pLivingEntity.getFeetBlockState();
            if(state.is(Blocks.WATER)) {
                state = Blocks.ICE.defaultBlockState();
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

}
