package net.todobek.terrapotions.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.todobek.terrapotions.TerraPotions;

import java.awt.*;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TerraPotions.MOD_ID);

    public static final RegistryObject<MobEffect> IRONSKIN = MOB_EFFECTS.register("ironskin",
            () -> new IronskinEffect(MobEffectCategory.BENEFICIAL, 	25020760));

    public static final RegistryObject<MobEffect> BATTLE = MOB_EFFECTS.register("battle",
            () -> new BattleEffect(MobEffectCategory.NEUTRAL, 3124687));

    public static final RegistryObject<MobEffect> CALMING = MOB_EFFECTS.register("calming",
            () -> new CalmingEffect(MobEffectCategory.NEUTRAL, 3145523));

    public static final RegistryObject<MobEffect> MINING = MOB_EFFECTS.register("mining",
            () -> new MiningEffect(MobEffectCategory.BENEFICIAL, 53162222));

    public static final RegistryObject<MobEffect> BUILDER = MOB_EFFECTS.register("builder",
            () -> new BuilderEffect(MobEffectCategory.BENEFICIAL, 2552411));

    public static final RegistryObject<MobEffect> GRAVITATION = MOB_EFFECTS.register("gravitation",
            () -> new GravitationEffect(MobEffectCategory.BENEFICIAL, 3124687));

    public static final RegistryObject<MobEffect> FEATHERFALL = MOB_EFFECTS.register("featherfall",
            () -> new FeatherfallEffect(MobEffectCategory.BENEFICIAL, 164180222));

    public static final RegistryObject<MobEffect> HUNTER = MOB_EFFECTS.register("hunter",
            () -> new HunterEffect(MobEffectCategory.BENEFICIAL, 24614359));

    public static final RegistryObject<MobEffect> INFERNO = MOB_EFFECTS.register("inferno",
            () -> new InfernoEffect(MobEffectCategory.BENEFICIAL, 2447838));

    public static final RegistryObject<MobEffect> LIFEFORCE = MOB_EFFECTS.register("lifeforce",
            () -> new LifeforceEffect(MobEffectCategory.BENEFICIAL, 2551048));

    public static final RegistryObject<MobEffect> TITAN = MOB_EFFECTS.register("titan",
            () -> new TitanEffect(MobEffectCategory.BENEFICIAL, 110010255));

    public static final RegistryObject<MobEffect> THORNS = MOB_EFFECTS.register("thorns",
            () -> new ThornsEffect(MobEffectCategory.BENEFICIAL, 178222053));

    public static final RegistryObject<MobEffect> WATERWALKING = MOB_EFFECTS.register("waterwalking",
            () -> new WaterWalkingEffect(MobEffectCategory.BENEFICIAL, 31234687));

    public static final RegistryObject<MobEffect> DRUNK = MOB_EFFECTS.register("drunk",
            () -> new DrunkEffect(MobEffectCategory.BENEFICIAL, 255159123));
    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }

}
