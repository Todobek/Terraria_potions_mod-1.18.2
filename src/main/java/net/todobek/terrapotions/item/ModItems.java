package net.todobek.terrapotions.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.todobek.terrapotions.TerraPotions;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
                DeferredRegister.create(ForgeRegistries.ITEMS, TerraPotions.MOD_ID);


    public static final RegistryObject<Item> GEL = ITEMS.register("gel",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TERRAPOTIONS_TAB)));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
