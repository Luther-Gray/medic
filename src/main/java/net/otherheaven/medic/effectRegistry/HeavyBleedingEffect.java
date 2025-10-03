package net.otherheaven.medic.effectRegistry;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class HeavyBleedingEffect extends StatusEffect {
    public HeavyBleedingEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        float damage = 1.0F + amplifier;
        entity.damage(entity.getDamageSources().magic(),damage);
            return super.applyUpdateEffect(entity, amplifier);
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
