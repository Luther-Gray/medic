package net.otherheaven.medic.itemRegistry.medicItemFunctions;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.otherheaven.medic.effectRegistry.MedicEffects;

public class SalveItem extends Item {
//    You can stack 8 of these mfs
    public SalveItem(Settings settings) {
        super(settings.maxCount(8));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
//        Use Conditions
        if(playerEntity.getHealth() <= playerEntity.getMaxHealth()){
            ItemStack itemStack = playerEntity.getStackInHand(hand);
            playerEntity.playSound(SoundEvents.BLOCK_SLIME_BLOCK_BREAK, 1.0F, 0.5F);
//            Amount Healed
            double healAmount = playerEntity.getMaxHealth() * 0.30;
            playerEntity.heal((float) healAmount);
//            Additional Effect
            playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1, false, false));
//            Cure Injury
            if ((playerEntity.hasStatusEffect(MedicEffects.FROSTBITE) || playerEntity.hasStatusEffect(MedicEffects.HEATSTROKE))) {
                playerEntity.removeStatusEffect(MedicEffects.FROSTBITE);
                playerEntity.removeStatusEffect(MedicEffects.HEATSTROKE);
                playerEntity.removeStatusEffect(StatusEffects.NAUSEA);
                playerEntity.removeStatusEffect(StatusEffects.MINING_FATIGUE);
//                Add Recovery
                playerEntity.addStatusEffect(new StatusEffectInstance(MedicEffects.BFRECOVERY, 900, 0));
            }
            itemStack.decrement(1);
            return TypedActionResult.consume(itemStack);
        }
        return TypedActionResult.fail(playerEntity.getStackInHand(hand));
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if(entity.getHealth() <= entity.getMaxHealth()){
            ItemStack itemStack = user.getStackInHand(hand);
            entity.playSound(SoundEvents.BLOCK_SLIME_BLOCK_BREAK, 1.0F, 0.8F);
            double healAmount = entity .getMaxHealth() * 0.30;
            entity.heal((float) healAmount);
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1, false, false));
            if ((entity.hasStatusEffect(MedicEffects.FROSTBITE) || entity.hasStatusEffect(MedicEffects.HEATSTROKE))) {
                entity.removeStatusEffect(MedicEffects.FROSTBITE);
                entity.removeStatusEffect(MedicEffects.HEATSTROKE);
                entity.removeStatusEffect(StatusEffects.NAUSEA);
                entity.removeStatusEffect(StatusEffects.MINING_FATIGUE);
//                Add Recovery
                entity.addStatusEffect(new StatusEffectInstance(MedicEffects.BFRECOVERY, 900, 0));
            }
            itemStack.decrement(1);
            return ActionResult.CONSUME;
        }
        return ActionResult.PASS;
    }
}
