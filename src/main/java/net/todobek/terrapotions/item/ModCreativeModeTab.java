package net.todobek.terrapotions.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab TERRAPOTIONS_TAB = new CreativeModeTab("terrapotionstab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.GEL.get());
        }
    };
}
