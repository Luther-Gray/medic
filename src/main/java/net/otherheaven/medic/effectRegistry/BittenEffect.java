package net.otherheaven.medic.effectRegistry;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;

public class BittenEffect extends StatusEffect {
    private static final double INFECTION_CHANCE = 0.25; // Chance to get infected. NOT the chance to get bitten! Look at the math in Zombie Mixin for that.
    public static final int INFECTION_DURATION = 1000; // This is how long you are Infected for. Default - 6000

    public BittenEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getRandom().nextDouble() < INFECTION_CHANCE) {
            if (entity.getHealth() > 1.0F) {
                entity.addStatusEffect(new StatusEffectInstance(
                        MedicEffects.INFECTED, INFECTION_DURATION, 0
                ));
            }
        }

        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration == 1;
    }
}
