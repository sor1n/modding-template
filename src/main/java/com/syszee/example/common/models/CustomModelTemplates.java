package com.syszee.example.common.models;

import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

public class CustomModelTemplates
{
    public static final ModelTemplate SPAWN_EGG = createItem("template_spawn_egg");

    private static ModelTemplate createItem(String string, TextureSlot... args)
    {
        return new ModelTemplate(Optional.of(new ResourceLocation("minecraft", "item/" + string)), Optional.empty(), args);
    }
}
