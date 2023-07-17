package net.todobek.terrapotions;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.todobek.terrapotions.effect.ModEffects;
import net.todobek.terrapotions.item.ModItems;
import net.todobek.terrapotions.potion.ModPotions;
import net.todobek.terrapotions.util.BetterBrewingRecipe;
import net.todobek.terrapotions.villager.ModVillagers;
import org.slf4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TerraPotions.MOD_ID)
public class TerraPotions
{

    public static final String MOD_ID = "terrapotions";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();


    public TerraPotions()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);

        ModEffects.register(eventBus);

        ModPotions.register(eventBus);

        ModVillagers.register(eventBus);

        eventBus.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);


    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
           ModVillagers.registerPOIs();

            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                    Items.IRON_INGOT, ModPotions.IRONSKIN_POTION.get()));

            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                    Items.BLUE_ORCHID, ModPotions.BUILDER_POTION.get()));

            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                    Items.PUFFERFISH, ModPotions.HUNTER_POTION.get()));

            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                    Items.COOKED_SALMON, ModPotions.LIFEFORCE_POTION.get()));

            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                    Items.BONE, ModPotions.MINING_POTION.get()));

            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                    Items.GHAST_TEAR, ModPotions.INFERNO_POTION.get()));

            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                    Items.CACTUS, ModPotions.THORNS_POTION.get()));

            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                    Items.GUNPOWDER, ModPotions.TITAN_POTION.get()));

            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                    Items.POPPY, ModPotions.ALE.get()));

        });


        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

}
