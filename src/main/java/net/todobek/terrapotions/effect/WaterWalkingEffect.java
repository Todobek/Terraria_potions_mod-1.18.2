package net.todobek.terrapotions.effect;

import com.sun.jna.platform.unix.X11;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeConfig;
import net.minecraftforge.event.world.WorldEvent;

import javax.xml.crypto.Data;

public class WaterWalkingEffect extends MobEffect {

    private BlockPos oldBlock;
    public WaterWalkingEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
        oldBlock = null;

    }
    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        super.applyEffectTick(pLivingEntity, pAmplifier);
        BlockPos playerPos = new BlockPos(pLivingEntity.getX(), pLivingEntity.getY() - 1, pLivingEntity.getZ());
        Level world = pLivingEntity.level;
        BlockState currentState = world.getBlockState(playerPos);

        if (currentState.getBlock() == Blocks.WATER) {
            BlockState iceState = Blocks.ICE.defaultBlockState();
            world.setBlockAndUpdate(playerPos, iceState);

            if (oldBlock!=null && !oldBlock.equals(playerPos)) {
                BlockState airState = Blocks.AIR.defaultBlockState();
                world.setBlockAndUpdate(oldBlock, airState);
            }
            oldBlock = playerPos;
        }
        else {
            oldBlock = null;
        }
    }


    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

}
