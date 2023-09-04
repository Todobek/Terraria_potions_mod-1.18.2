package net.todobek.terrapotions.potion;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.todobek.terrapotions.TerraPotions;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.todobek.terrapotions.effect.ModEffects;
import net.todobek.terrapotions.item.ModCreativeModeTab;
import org.lwjgl.system.CallbackI;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS
    = DeferredRegister.create(ForgeRegistries.POTIONS, TerraPotions.MOD_ID);

    public static final RegistryObject<Potion> IRONSKIN_POTION = POTIONS.register("ironskin_potion",
           () -> new Potion(new MobEffectInstance(ModEffects.IRONSKIN.get(), 2400, 0)));

    public static final RegistryObject<Potion> BUILDER_POTION = POTIONS.register("builder_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.BUILDER.get(), 24000, 0)));

    public static final RegistryObject<Potion> ALE = POTIONS.register("ale",
            () -> new Potion(new MobEffectInstance(ModEffects.DRUNK.get(), 1200, 0)));

    public static final RegistryObject<Potion> HUNTER_POTION = POTIONS.register("hunter_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.HUNTER.get(), 3600, 0)));

    public static final RegistryObject<Potion> INFERNO_POTION = POTIONS.register("inferno_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.INFERNO.get(), 4800, 0)));


    public static final RegistryObject<Potion> MINING_POTION = POTIONS.register("mining_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.MINING.get(), 6000, 0)));

    public static final RegistryObject<Potion> THORNS_POTION = POTIONS.register("thorns_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.THORNS.get(), 4800, 0)));

    public static final RegistryObject<Potion> TITAN_POTION = POTIONS.register("titan_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.TITAN.get(), 4800, 0)));



    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }

}
