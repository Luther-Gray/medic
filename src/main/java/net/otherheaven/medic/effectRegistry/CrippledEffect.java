package net.otherheaven.medic.effectRegistry;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class CrippledEffect extends StatusEffect {
    public CrippledEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (amplifier >= 1) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 3600, 2, false, false, false));
        } else {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 3600, amplifier, false, false, false));
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
