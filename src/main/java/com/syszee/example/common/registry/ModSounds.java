package com.syszee.example.common.registry;

import com.syszee.example.ModMain;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSounds
{
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ModMain.MOD_ID);

//    public static final RegistryObject<SoundEvent> EXAMPLE_SOUND = register("example");
//    public static final ForgeSoundType EXAMPLE_SOUND_TYPE = new ForgeSoundType(0.3F, 1.0F,
//        ModSounds.EXAMPLE_BREAK_SOUND::get,
//        ModSounds.EXAMPLE_STEP_SOUND::get,
//        ModSounds.EXAMPLE_PLACE_SOUND::get,
//        ModSounds.EXAMPLE_HIT_SOUND::get,
//        ModSounds.EXAMPLE_FALL_SOUND::get);

    /* Registry Methods */

    /**
     * Registers a new sound event under the specified id.
     *
     * @param id The id of the sound event
     */
    private static RegistryObject<SoundEvent> register(String id)
    {
        return SOUNDS.register(id, () -> new SoundEvent(new ResourceLocation(ModMain.MOD_ID, id)));
    }
}