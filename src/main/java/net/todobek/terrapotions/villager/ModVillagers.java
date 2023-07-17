package net.todobek.terrapotions.villager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.todobek.terrapotions.TerraPotions;
import org.lwjgl.system.CallbackI;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES
            = DeferredRegister.create(ForgeRegistries.POI_TYPES, TerraPotions.MOD_ID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS
            = DeferredRegister.create(ForgeRegistries.PROFESSIONS, TerraPotions.MOD_ID);


    public static final RegistryObject<PoiType> TERRA_ALCHEMY_POI = POI_TYPES.register("terra_alchemy_poi",
            () -> new PoiType("terra_alchemy_poi",
                    PoiType.getBlockStates(Blocks.GLOWSTONE), 1, 1));

    public static final RegistryObject<VillagerProfession> TERRA_ALCHEMIST = VILLAGER_PROFESSIONS.register("terra_alchemist",
            () -> new VillagerProfession("terra_alchemist", TERRA_ALCHEMY_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_LIBRARIAN));


    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, TERRA_ALCHEMY_POI.get());
        } catch(InvocationTargetException | IllegalAccessException exception) {            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {

        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);


    }


}

