package net.otherheaven.medic.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.otherheaven.medic.effectRegistry.MedicEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ZombieEntity.class)
public abstract class ZombieEntityMixin extends HostileEntity {

    protected ZombieEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tryAttack", at = @At("HEAD"))
    private void injectTryAttack(Entity target, CallbackInfoReturnable<Boolean> cir) {
        if (target instanceof PlayerEntity playerEntity && !playerEntity.hasStatusEffect(MedicEffects.BITTEN)) {
            double armorPoints = playerEntity.getAttributeValue(EntityAttributes.GENERIC_ARMOR);
            double maxArmor = 30.0; // This is Vanilla's Max. But what if a mod uncaps this??? 😧
            double biteChance = Math.max(0.05, 0.95 - (armorPoints / maxArmor));

            if (this.random.nextDouble() < biteChance) {
                playerEntity.addStatusEffect(new StatusEffectInstance(MedicEffects.BITTEN, 200), this); // Duration is how long Bitten takes to resolve. It's a grace period. An "oh god! I got bit!" thing. Default - 200
            }
        }
    }
}
