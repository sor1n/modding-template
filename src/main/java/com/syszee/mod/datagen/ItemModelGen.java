package com.syszee.mod.datagen;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.syszee.mod.ModMain;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class ItemModelGen implements IDataProvider
{
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private final DataGenerator dataGenerator;
    private BiConsumer<ResourceLocation, Supplier<JsonElement>> consumer;

    public ItemModelGen(DataGenerator dataGenerator)
    {
        this.dataGenerator = dataGenerator;
    }

    @Override
    public void act(DirectoryCache cache)
    {
        Path path = this.dataGenerator.getOutputFolder();
        Map<ResourceLocation, Supplier<JsonElement>> map1 = Maps.newHashMap();
        this.consumer = (location, json) ->
        {
            Supplier<JsonElement> supplier = map1.put(location, json);
            if (supplier != null)
            {
                throw new IllegalStateException("Duplicate model definition for " + location);
            }
        };
        this.register();
        this.saveCollection(cache, path, map1, ItemModelGen::createModelPath);
    }

    private void register()
    {
    }

    private void generateFlatItem(Item item, ModelsUtil p_240076_2_)
    {
        p_240076_2_.func_240234_a_(ModelsResourceUtil.func_240219_a_(item), ModelTextures.func_240352_b_(item), this.consumer);
    }

    private void generateFlatItem(Item item, String p_240077_2_, ModelsUtil p_240077_3_)
    {
        p_240077_3_.func_240234_a_(ModelsResourceUtil.func_240220_a_(item, p_240077_2_), ModelTextures.func_240376_j_(ModelTextures.func_240344_a_(item, p_240077_2_)), this.consumer);
    }

    private void generateFlatItem(Item item, Item p_240075_2_, ModelsUtil p_240075_3_)
    {
        p_240075_3_.func_240234_a_(ModelsResourceUtil.func_240219_a_(item), ModelTextures.func_240352_b_(p_240075_2_), this.consumer);
    }

    private <T> void saveCollection(DirectoryCache cache, Path dataFolder, Map<T, ? extends Supplier<JsonElement>> models, BiFunction<Path, T, Path> resolver)
    {
        models.forEach((p_240088_3_, p_240088_4_) ->
        {
            Path path = resolver.apply(dataFolder, p_240088_3_);

            try
            {
                IDataProvider.save(GSON, cache, p_240088_4_.get(), path);
            }
            catch (Exception exception)
            {
                LOGGER.error("Couldn't save {}", path, exception);
            }
        });
    }

    private static Path createModelPath(Path dataFolder, ResourceLocation name)
    {
        return dataFolder.resolve("assets/" + name.getNamespace() + "/models/" + name.getPath() + ".json");
    }

    @Override
    public String getName()
    {
        return ModMain.MOD_ID + " Block State Definitions";
    }
}
