package com.syszee.example.common.potions;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import javax.annotation.Nullable;

public class PotionList
{
    public static class ExampleEffect extends MobEffect
    {
        public ExampleEffect(MobEffectCategory mobEffectCategory, int color) {
            super(mobEffectCategory, color);
        }

        /**
         * Applies the effect instantly; Only works if isInstantenous is true
         *
         * @param applyingEffectEntity The entity that applies the potion effect (this can be a living entity, cloud effect or thrown potions)
         * @param sourceEffectEntity The source of the entity (this is for splash and lingering potions to determine who threw them)
         * @param affectedEntity The entity affected by the potion
         * @param tick The time of the potion
         * @param power The strength of the potion
         */
        public void applyInstantenousEffect(@Nullable Entity applyingEffectEntity, @Nullable Entity sourceEffectEntity, LivingEntity affectedEntity, int tick, double power)
        {
            super.applyInstantenousEffect(applyingEffectEntity, sourceEffectEntity, affectedEntity, tick, power);
        }

        // Continuously runs this function as long as the effect is ticking AND if isDurationEffectTick is true
        // Does not work if the effect is instantaneous
        public void applyEffectTick(LivingEntity affectedEntity, int power) {
        }

        // Determines whether to apply the effect tick
        public boolean isDurationEffectTick(int tick, int power) { return true; }

        // Determines if the effect is instantaneous or not
        public boolean isInstantenous() { return false; }
    }
}
