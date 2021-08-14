package com.syszee.example.datagen;

import com.syszee.example.ModMain;
import com.syszee.example.common.loot.AdditionalLootModifier;
import com.syszee.example.common.registry.ModEntities;
import com.syszee.example.common.registry.ModLootTables;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class GlobalLootModifierProviderGen extends GlobalLootModifierProvider
{
    public GlobalLootModifierProviderGen(DataGenerator gen)
    {
        super(gen, ModMain.MOD_ID);
    }

    @Override
    protected void start()
    {
        /*this.add("example_loot_modifier", ModLootTables.ADDITIONAL_LOOT_MODIFIER.get(),
            new AdditionalLootModifier(new LootItemCondition[]
                {
                    LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().of(ModEntities.EXAMPLE_ENTITY.get())).build()
                },
            ModLootTables.EXAMPLE_ENTITY_LOOT)
        );*/
    }
}
