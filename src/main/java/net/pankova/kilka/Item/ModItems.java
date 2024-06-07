package net.pankova.kilka.Item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pankova.kilka.Kilka;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Kilka.MOD_ID);

    public static final RegistryObject<Item> MEDUZA = ITEMS.register("meduza",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MEDUZA_TAB)));

    public static final RegistryObject<Item> FISHMECH = ITEMS.register("fishmech",
            () -> new FishMechSword());

    public static final RegistryObject<Item> VODOROSLI = ITEMS.register("vodorosli",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.6f).effect(() ->
                    new MobEffectInstance(MobEffects.WATER_BREATHING, 200, 0), 1.0f).build()).tab(ModCreativeModeTab.MEDUZA_TAB)));

    public static final RegistryObject<Item> SEA_BOMB = ITEMS.register("sea_bomb",
            () -> new SeaBombItem(new Item.Properties().tab(ModCreativeModeTab.MEDUZA_TAB)));

    public static void register(IEventBus eventBus){

        ITEMS.register(eventBus);
    }
}