package com.syszee.example.common.registry;

import com.syszee.example.ModMain;
import io.github.ocelot.sonar.common.item.SpawnEggItemBase;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.monster.Husk;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid = ModMain.MOD_ID)
public class ModEntities
{
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, ModMain.MOD_ID);
    public static final Set<RegistryObject<SpawnEggItemBase<?>>> SPAWN_EGGS = new HashSet<>();

//    public static final RegistryObject<EntityType<ExampleEntity>> EXAMPLE_ENTITY = register("example_entity", EntityType.Builder.of(ExampleEntity::new, MobCategory.MISC).sized(1.0F, 1.0F).clientTrackingRange(10), 0xff00ff, 0xffff00);

    @SubscribeEvent
    public static void onEvent(BiomeLoadingEvent event)
    {
        // if (event.getCategory() == Biome.Category.PLAINS)
        // event.getSpawns().getSpawner(EntityClassification.MISC).add(new MobSpawnInfo.Spawners(EXAMPLE.get(), 8, 4, 4));
    }

    /* Registry Methods */

    /**
     * Registers a new entity with an egg under the specified id.
     *
     * @param id             The id of the entity
     * @param builder        The entity builder
     * @param primaryColor   The egg color of the egg item
     * @param secondaryColor The spot color for the egg item
     * @param <T>            The type of entity being created
     */
    private static <T extends Entity> RegistryObject<EntityType<T>> register(String id, EntityType.Builder<T> builder, int primaryColor, int secondaryColor)
    {
        RegistryObject<EntityType<T>> object = register(id, builder);
        SPAWN_EGGS.add(ModItems.ITEMS.register(id + "_spawn_egg", () -> new SpawnEggItemBase<>(object, primaryColor, secondaryColor, true, new Item.Properties().tab(CreativeModeTab.TAB_MISC))));
        return object;
    }

    /**
     * Registers a new entity under the specified id.
     *
     * @param id      The id of the entity
     * @param builder The entity builder
     * @param <T>     The type of entity being created
     */
    private static <T extends Entity> RegistryObject<EntityType<T>> register(String id, EntityType.Builder<T> builder)
    {
        return ENTITIES.register(id, () -> builder.build(id));
    }
}