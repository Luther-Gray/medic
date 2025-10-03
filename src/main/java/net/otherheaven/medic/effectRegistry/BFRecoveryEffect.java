package net.otherheaven.medic.effectRegistry;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

// Burnt/Frostbite Recovery
public class BFRecoveryEffect extends StatusEffect {
    public BFRecoveryEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getHealth() > 1.0F) {
            if (entity instanceof PlayerEntity player) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 600, -1, false, false, false));
            }
//            Block reapplications of Status
            if (entity.hasStatusEffect(MedicEffects.FROSTBITE) || entity.hasStatusEffect(MedicEffects.HEATSTROKE)) {
                entity.removeStatusEffect(MedicEffects.FROSTBITE);
                entity.removeStatusEffect(MedicEffects.HEATSTROKE);
                entity.removeStatusEffect(StatusEffects.NAUSEA);
                entity.removeStatusEffect(StatusEffects.MINING_FATIGUE);
            }

            return super.applyUpdateEffect(entity, amplifier);
        }
        return true;
    }
    @Override
    public boolean canApplyUpdateEffect ( int duration, int amplifier){
        int i = 20 >> amplifier;
        if (i > 0) {
            return duration % i == 0;
        } else {
            return true;
        }
    }
}
