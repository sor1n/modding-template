package com.syszee.example.common.registry;

import com.syszee.example.ModMain;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModPotions
{
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTION_TYPES, ModMain.MOD_ID);

    // Creates a set of potions based on the effect: potion, splash potion, lingering potion and tipped arrows
    // Last value is duration of the potion in ticks; 20 ticks = 1s
//    public static final RegistryObject<Potion> EXAMPLE_POTION = POTIONS.register("example_potion", () -> new Potion(new MobEffectInstance(ModEffects.EXAMPLE_EFFECT.get(), 200)));
//    public static final RegistryObject<Potion> EXAMPLE_LONG_POTION = POTIONS.register("long_example_potion", () -> new Potion("example_potion", new MobEffectInstance(ModEffects.EXAMPLE_EFFECT.get(), 600)));
//    public static final RegistryObject<Potion> EXAMPLE_STRONG_POTION = POTIONS.register("strong_example_potion", () -> new Potion("example_potion", new MobEffectInstance(ModEffects.EXAMPLE_EFFECT.get(), 200, 1)));

    /**
     * Registers a new potion under the specified name.
     *
     * @param name The name of the potion
     * @param potion The potion to register
     * @return The object created when registering the potion
     */
    public static <T extends Potion> RegistryObject<T> register(String name, Supplier<? extends T> potion)
    {
        RegistryObject<T> object = POTIONS.register(name, potion);
        return object;
    }
}