package net.otherheaven.medic.effectRegistry;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class InfectedEffect extends StatusEffect {
    public InfectedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    // Infection Stages. Each stage is applied and stays until it's all over.
    private int getInfectionStage(int ticksRemaining) {
        int totalDuration = BittenEffect.INFECTION_DURATION;
        if (ticksRemaining <= 0) {
            // The Infection Claims you.
            return 4;
        }

        if (ticksRemaining <= totalDuration / 3) {
            // Stage 3 - Feeble
            return 3;
        }

        if (ticksRemaining <= totalDuration / 1.5) {
            // Stage 2 - Darkness
            return 2;
        }

        if (ticksRemaining <= totalDuration) {
            // Stage 1 - Nausea
            return 1;
        }

        else {
            return 0;
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration == 1;
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.hasStatusEffect(MedicEffects.INFECTED)) {
            StatusEffectInstance infectionEffect = entity.getStatusEffect(MedicEffects.INFECTED);
            if (infectionEffect != null) {
                int ticksRemaining = infectionEffect.getDuration();
                // Infection Evolution starts here. The longer you have it, the more severe the effects.
                switch (getInfectionStage(ticksRemaining)) {
                    case 1:
                        // Stage 1 effects: Nausea
                        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 1000, 0));
                        break;
                    case 2:
                        // Stage 2 effects: Darkness
                        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 1000, 0));
                        break;
                    case 3:
                        // Stage 3 effects: Weakness and Slowness
                        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 1000, 0));
                        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 1000, 0));
                        break;
                    case 4:
                        // Death stage
                        entity.kill();
                        break;
                    default:
                        break;
                }
            }
        }
        return super.applyUpdateEffect(entity, amplifier);
    }
}
