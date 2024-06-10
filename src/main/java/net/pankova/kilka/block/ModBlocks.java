package net.pankova.kilka.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pankova.kilka.Item.ModCreativeModeTab;
import net.pankova.kilka.Item.ModItems;
import net.pankova.kilka.Kilka;


import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Kilka.MOD_ID);

    public static final RegistryObject<Block> SEA_WATER  = registryBlock("sea_water", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WATER)
                    .noCollission()
                    .strength(100.0F)),
            ModCreativeModeTab.MEDUZA_TAB);
    public static final RegistryObject<Block> LIGHTHOUSE  = registryBlock("lighthouse", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(100.0F)
                    .lightLevel((state) -> 15)
                    .sound(SoundType.STONE)),
            ModCreativeModeTab.MEDUZA_TAB);
    public static final RegistryObject<Block> PESOK  = registryBlock("pesok", () -> new FallingBlock(BlockBehaviour.Properties.of(Material.SAND)
                    .strength(0.5f).sound(SoundType.SAND)),
            ModCreativeModeTab.MEDUZA_TAB);

    public static final RegistryObject<Block> GUBKA  = registryBlock("gubka", () -> new SpongeBlock(BlockBehaviour.Properties.of(Material.SPONGE)
                    .strength(0.6f).sound(SoundType.GRASS).noOcclusion()),
            ModCreativeModeTab.MEDUZA_TAB);

    public static final RegistryObject<Block> CORALCHEST = registryBlock("coralchest",
            CoralChestBlock::new, ModCreativeModeTab.MEDUZA_TAB);

    public static <T extends Block>RegistryObject<T> registryBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturns = BLOCKS.register(name, block);
        registryBlockItem(name, toReturns, tab);
    return toReturns;

    }
    public static <T extends Block> RegistryObject<Item> registryBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus){

        BLOCKS.register(eventBus);
    }
}
