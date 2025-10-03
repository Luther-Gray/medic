package net.otherheaven.medic.effectRegistry;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

// Cripple Recovery
public class CRecoveryEffect extends StatusEffect {
    public CRecoveryEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getHealth() > 1.0F) {
//            There's no way that players are going to start throwing themselves from rooftops to get the Resistance right? Splints aren't simple crafts.
            if (entity instanceof PlayerEntity player) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 900, 0, false, false, false));
            }
//            Block reapplications of Status
            if (entity.hasStatusEffect(MedicEffects.CRIPPLED)) {
                entity.removeStatusEffect(MedicEffects.CRIPPLED);
                entity.removeStatusEffect(StatusEffects.WEAKNESS);
                entity.removeStatusEffect(StatusEffects.SLOWNESS);
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
