package net.todobek.terrapotions.effect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class IronskinEffect extends MobEffect{

    private boolean applied = false;
    public IronskinEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }


    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

        if(!applied) {
            float x = pLivingEntity.getArmorCoverPercentage();

            pLivingEntity.getAttribute(Attributes.ARMOR).setBaseValue(x+4);

            applied = true;
        }



        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    public void removeAttributeModifiers(LivingEntity pLivingEntity, AttributeMap pAttributeMap, int pAmplifier)  {
            if(applied) {
                float x = pLivingEntity.getArmorCoverPercentage();

                pLivingEntity.getAttribute(Attributes.ARMOR).setBaseValue(x-4);

                applied = false;
            }
    }

    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
