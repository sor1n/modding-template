package com.syszee.example.common.registry;

import com.syszee.example.ModMain;
import com.syszee.example.common.potions.PotionList;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModEffects
{
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, ModMain.MOD_ID);

    // public static final RegistryObject<MobEffect> EXAMPLE_EFFECT = EFFECTS.register("example", () -> new PotionList.ExampleEffect(MobEffectCategory.NEUTRAL, 0xffff00));

    /**
     * Registers a new effect under the specified name.
     *
     * @param name The name of the effect
     * @param effect The effect to register
     * @return The object created when registering the effect
     */
    public static <T extends MobEffect> RegistryObject<T> register(String name, Supplier<? extends T> effect)
    {
        RegistryObject<T> object = EFFECTS.register(name, effect);
        return object;
    }
}