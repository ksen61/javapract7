package net.pankova.kilka.Item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class FishMechSword extends SwordItem {
    public FishMechSword() {
        super(Tiers.IRON, 5, 2.4F, new Item.Properties().tab(ModCreativeModeTab.MEDUZA_TAB));
    }
}
