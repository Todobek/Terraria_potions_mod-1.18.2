package net.todobek.terrapotions.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.todobek.terrapotions.TerraPotions;
import net.todobek.terrapotions.potion.ModPotions;
import net.todobek.terrapotions.villager.ModVillagers;

import java.util.List;

@Mod.EventBusSubscriber(modid = TerraPotions.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == ModVillagers.TERRA_ALCHEMIST.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            Item builderPotionItem = ForgeRegistries.ITEMS.getValue(ModPotions.BUILDER_POTION.getId());

            if(builderPotionItem != null) {
                ItemStack stack = new ItemStack(builderPotionItem, 1);

                Potion potion = ForgeRegistries.POTIONS.getValue(ModPotions.BUILDER_POTION.getId());
                ItemStack potionStack = PotionUtils.setPotion(stack, potion);

                int villagerLevel = 1;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 5),
                        potionStack,4,12,0.09F));
            }

        }
    }
}
