package net.otherheaven.medic.effectRegistry;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.otherheaven.medic.Medic;

public class MedicEffects {

    public static final RegistryEntry<StatusEffect> BLEEDING = registerStatusEffect("bleeding", new BleedEffect(StatusEffectCategory.HARMFUL, 0xFF914030));
    public static final RegistryEntry<StatusEffect> CRIPPLED = registerStatusEffect("crippled", new CrippledEffect(StatusEffectCategory.HARMFUL, 0xA0A0A0));
    public static final RegistryEntry<StatusEffect> HEATSTROKE = registerStatusEffect("heatstroke", new HeatstrokeEffect(StatusEffectCategory.HARMFUL, 0xFF4500));
    public static final RegistryEntry<StatusEffect> FROSTBITE = registerStatusEffect("frostbite", new FrostbiteEffect(StatusEffectCategory.HARMFUL, 0xA0D0D0));
    public static final RegistryEntry<StatusEffect> HEAVYBLEEDING = registerStatusEffect("heavy_bleeding", new HeavyBleedingEffect(StatusEffectCategory.HARMFUL, 0xFF6A0000));
    public static final RegistryEntry<StatusEffect> REMISSION = registerStatusEffect("remission", new RemissionEffect(StatusEffectCategory.BENEFICIAL, 0xFF66C28B));
    public static final RegistryEntry<StatusEffect> BITTEN = registerStatusEffect("bitten", new BittenEffect(StatusEffectCategory.NEUTRAL, 0xFFA0FF00));
    public static final RegistryEntry<StatusEffect> INFECTED = registerStatusEffect("infected", new InfectedEffect(StatusEffectCategory.HARMFUL, 0xFFA0FF00));

//    Recovery Statuses | They prevent stacking debuffs thank god.
    public static final RegistryEntry<StatusEffect> HBRECOVERY = registerStatusEffect("hb_recovery", new HBRecoveryEffect(StatusEffectCategory.BENEFICIAL, 0xE6CC));
    public static final RegistryEntry<StatusEffect> CRECOVERY = registerStatusEffect("c_recovery", new CRecoveryEffect(StatusEffectCategory.BENEFICIAL, 0xE6CC));
    public static final RegistryEntry<StatusEffect> BFRECOVERY = registerStatusEffect("bf_recovery", new BFRecoveryEffect(StatusEffectCategory.BENEFICIAL, 0xE6CC));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return  Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Medic.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        Medic.LOGGER.info("Registering " + Medic.MOD_ID + " Effects.");
    }
}
