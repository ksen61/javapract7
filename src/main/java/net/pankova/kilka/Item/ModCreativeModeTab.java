package net.pankova.kilka.Item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab MEDUZA_TAB = new CreativeModeTab("Meduza Tab") {
        @Override
        public ItemStack makeIcon() {

            return new ItemStack(ModItems.MEDUZA.get());
        }
    };
}
