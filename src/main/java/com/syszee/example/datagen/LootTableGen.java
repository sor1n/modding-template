package com.syszee.example.datagen;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.syszee.example.ModMain;
import com.syszee.example.common.registry.ModBlocks;
import com.syszee.example.common.registry.ModItems;
import com.syszee.example.common.registry.ModLootTables;
import net.minecraft.advancements.critereon.FishingHookPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.*;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraftforge.common.data.ForgeLootTableProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LootTableGen extends ForgeLootTableProvider
{
    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> tables = ImmutableList.of(Pair.of(FishingProvider::new, LootContextParamSets.FISHING), Pair.of(ChestProvider::new, LootContextParamSets.CHEST), Pair.of(EntityProvider::new, LootContextParamSets.ENTITY), Pair.of(BlockProvider::new, LootContextParamSets.BLOCK), Pair.of(PiglinBarteringProvider::new, LootContextParamSets.PIGLIN_BARTER), Pair.of(GiftProvider::new, LootContextParamSets.GIFT));

    public LootTableGen(DataGenerator generator)
    {
        super(generator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables()
    {
        return tables;
    }

    private static class FishingProvider extends FishingLoot
    {
        @Override
        public void accept(BiConsumer<ResourceLocation, LootTable.Builder> registry)
        {
            /*registry.accept(BuiltInLootTables.FISHING,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantIntValue.exactly(1))
                    .add(LootTableReference.lootTableReference(BuiltInLootTables.FISHING_JUNK).setWeight(10).setQuality(-2))
                    .add(LootTableReference.lootTableReference(BuiltInLootTables.FISHING_TREASURE).setWeight(5).setQuality(2)
                            .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, net.minecraft.advancements.critereon.EntityPredicate.Builder.entity().fishingHook(FishingHookPredicate.inOpenWater(true)))))
                    .add(LootTableReference.lootTableReference(BuiltInLootTables.FISHING_FISH).setWeight(85).setQuality(-1))
                    .add(LootTableReference.lootTableReference(ModLootTables.EXAMPLE_FISHING_LOOT).setWeight(20).setQuality(-3))));

            registry.accept(ModLootTables.EXAMPLE_FISHING_LOOT, LootTable.lootTable()
            .withPool(LootPool.lootPool()
                .name("pool1")
                .setRolls(RandomValueBounds.between(2, 5))
                .add(LootItem.lootTableItem(ModItems.EXAMPLE_ITEM.get()))
            )
            .withPool(LootPool.lootPool()
                .name("pool2")
                .add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(20))
                .add(LootItem.lootTableItem(Items.DIAMOND).setWeight(10))
                .add(LootItem.lootTableItem(Items.EMERALD).setWeight(5))
            ));*/
        }
    }

    private static class ChestProvider extends ChestLoot
    {
        @Override
        public void accept(BiConsumer<ResourceLocation, LootTable.Builder> registry)
        {
        }
    }

    private static class EntityProvider extends EntityLoot
    {
        @Override
        protected void addTables()
        {
            /*this.add(ModLootTables.EXAMPLE_ENTITY_LOOT, LootTable.lootTable()
            .withPool(LootPool.lootPool()
                .name("pool1")
                .setRolls(RandomValueBounds.between(2, 5))
                .add(LootItem.lootTableItem(ModItems.EXAMPLE_ITEM.get()))
            ).withPool(LootPool.lootPool()
                .name("pool2")
                .setRolls(ConstantIntValue.exactly(10))
                .add(LootItem.lootTableItem(Items.PAPER))
                    .apply(LootingEnchantFunction.lootingMultiplier(RandomValueBounds.between(0.0F, 1.0F)))
            ).withPool(LootPool.lootPool()
                .name("pool3")
                .setRolls(BinomialDistributionGenerator.binomial(64, 1.0F))
                .add(LootItem.lootTableItem(Items.COAL))
                .add(LootItem.lootTableItem(Items.CHARCOAL))
                .add(LootItem.lootTableItem(Items.STICK))
            ));*/
        }

        @Override
        protected Iterable<EntityType<?>> getKnownEntities()
        {
            return ForgeRegistries.ENTITIES.getValues().stream().filter(entityType -> entityType.getRegistryName() != null && ModMain.MOD_ID.equals(entityType.getRegistryName().getNamespace())).collect(Collectors.toSet());
        }
    }

    private static class BlockProvider extends BlockLoot
    {
        @Override
        protected void addTables()
        {
            // A few common examples for block drops (look in BlockLoot for more examples):
//            this.dropSelf(ModBlocks.EXAMPLE_BLOCK.get());
//            this.dropOther(ModBlocks.EXAMPLE_BLOCK.get(), Blocks.STONE);
//            this.add(ModBlocks.EXAMPLE_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.STONE));
        }

        @Override
        protected Iterable<Block> getKnownBlocks()
        {
            return ForgeRegistries.BLOCKS.getValues().stream().filter(entityType -> entityType.getRegistryName() != null && ModMain.MOD_ID.equals(entityType.getRegistryName().getNamespace())).collect(Collectors.toSet());
        }
    }

    private static class PiglinBarteringProvider extends PiglinBarterLoot
    {
        @Override
        public void accept(BiConsumer<ResourceLocation, LootTable.Builder> registry)
        {
        }
    }

    private static class GiftProvider extends GiftLoot
    {
        @Override
        public void accept(BiConsumer<ResourceLocation, LootTable.Builder> registry)
        {
        }
    }
}