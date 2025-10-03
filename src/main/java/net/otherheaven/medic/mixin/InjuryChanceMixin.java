package net.otherheaven.medic.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.otherheaven.medic.effectRegistry.MedicEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// I named it terribly but this Mixin detects what damage is done to the player and adds the Injury associated with that damage type.
@Mixin(LivingEntity.class)
public abstract class InjuryChanceMixin {

    @Inject(method = "damage", at = @At("HEAD"))
    private void onDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity entity = (LivingEntity) (Object) this;
        if (entity instanceof PlayerEntity player) {
// Bleeding - Likely (10%)
            if ((source.getName().equals("cactus") || source.getName().equals("thorns") || source.getName().equals("player_attack")) && player.getWorld().random.nextFloat() < 0.1F) {
                player.addStatusEffect(new StatusEffectInstance(MedicEffects.BLEEDING, 600, 0));
            }
//            Bleeding - Unlikely (5%)
            if ((source.getName().equals("mob_attack") || source.getName().equals("generic") || source.getName().equals("sweet_berry_bush")) && player.getWorld().random.nextFloat() < 0.05F) {
                player.addStatusEffect(new StatusEffectInstance(MedicEffects.BLEEDING, 600, 0));
            }

// Heavy Bleeding - Somewhat Likely (50%)
            if (( source.getName().equals("arrow") ||  source.getName().equals("trident") || source.getName().equals("player_attack")) && player.getWorld().random.nextFloat() < 0.05F) {
                player.addStatusEffect(new StatusEffectInstance(MedicEffects.BLEEDING, 600, 0));
            }

//            Crippled - Very Likely (30%)
            if ((source.getName().equals("falling_anvil") || source.getName().equals("falling_block") || source.getName().equals("falling_stalactite") || source.getName().equals("fly_into_wall") || source.getName().equals("mace_smash")) && player.getWorld().random.nextFloat() < 0.3F) {
                player.addStatusEffect(new StatusEffectInstance(MedicEffects.CRIPPLED, 1200, 0));
            }
//            Crippled - Unlikely (10%)
            if((source.getName().equals("fall") || source.getName().equals("mob_attack_no_aggro") || source.getName().equals("sonic_boom") || source.getName().equals("thrown")) && player.getWorld().random.nextFloat() < 0.1F) {
                player.addStatusEffect(new StatusEffectInstance(MedicEffects.CRIPPLED, 1200, 0));
            }
//            Heatstroke - Unlikely (10%) Lightning doesn't work???
            if ((player.isOnFire() || source.getName().equals("campfire") || source.getName().equals("explosion") || source.getName().equals("fireball") || source.getName().equals("lava") || source.getName().equals("lightning_bolt") || source.getName().equals("player_explosion") && player.getWorld().random.nextFloat() < 0.1F)) {
                player.addStatusEffect(new StatusEffectInstance(MedicEffects.HEATSTROKE, 1200, 0));

//            Heatstroke - Rare (2%) This doesn't work
            if ((source.getName().equals("campfire") || source.getName().equals("hot_floor")) && player.getWorld().random.nextFloat() < 0.02F) {
                player.addStatusEffect(new StatusEffectInstance(MedicEffects.HEATSTROKE, 1200, 0));
            }

//            Frostbite - Likely (60%) WHY ISN'T THIS ONE WORKING?!
            if (source.getName().equals("freeze") && player.getWorld().random.nextFloat() < 0.6F) {
                player.addStatusEffect(new StatusEffectInstance(MedicEffects.FROSTBITE, 1200, 0));
            }

//            Bitten - Rare (30%) This doesn't work
            if ((source.getName().equals("campfire") || source.getName().equals("hot_floor")) && player.getWorld().random.nextFloat() < 0.02F) {
                player.addStatusEffect(new StatusEffectInstance(MedicEffects.HEATSTROKE, 1200, 0));
            }
        }
    }
}

}
