package com.syszee.example.datagen;

import com.syszee.example.ModMain;
import com.syszee.example.common.registry.ModEntities;
import io.github.ocelot.sonar.common.item.SpawnEggItemBase;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class LanguageGen extends LanguageProvider
{
    private final Map<EntityType<?>, String> entityNames;

    public LanguageGen(DataGenerator gen)
    {
        super(gen, ModMain.MOD_ID, "en_us");
        this.entityNames = new HashMap<>();
    }

    @Override
    protected void addTranslations()
    {
        for (RegistryObject<SpawnEggItemBase<?>> object : ModEntities.SPAWN_EGGS)
        {
            SpawnEggItemBase<?> spawnEggItem = object.get();
            this.add(spawnEggItem, this.entityNames.get(spawnEggItem.getType(null)) + " Spawn Egg");
        }
    }

    @Override
    public void addEntityType(Supplier<? extends EntityType<?>> key, String name)
    {
        super.addEntityType(key, name);
        this.entityNames.put(key.get(), name);
    }
}
