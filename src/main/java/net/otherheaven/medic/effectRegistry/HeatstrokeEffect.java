package net.otherheaven.medic.effectRegistry;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class HeatstrokeEffect extends StatusEffect {

    public HeatstrokeEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getHealth() >= 0.5F) {
//            showIcon is false but the Nausea is still showing?????
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 1200, 2, false, false, false));
        }
        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 20 >> amplifier;
        return i == 0 || duration % i == 0;
    }
}
