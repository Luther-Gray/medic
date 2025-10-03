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

public class MedKitItem extends Item {
//    Should the Med Kit also cure default statuses like poison? I never made an antidote item though. Need to think on that more.
    public MedKitItem(Settings settings) {
        super(settings.maxCount(1));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        if(playerEntity.getHealth() < playerEntity.getMaxHealth()){
            ItemStack itemStack = playerEntity.getStackInHand(hand);
            playerEntity.playSound(SoundEvents.ITEM_BOOK_PUT, 1.0F, 0.5F);
            double healAmount = playerEntity.getMaxHealth() * 1.0;
            playerEntity.heal((float) healAmount);
            playerEntity.removeStatusEffect(MedicEffects.BLEEDING);
            playerEntity.removeStatusEffect(MedicEffects.HEAVYBLEEDING);
            playerEntity.removeStatusEffect(MedicEffects.CRIPPLED);
            playerEntity.removeStatusEffect(MedicEffects.HEATSTROKE);
            playerEntity.removeStatusEffect(MedicEffects.FROSTBITE);
//                Remove Recoveries as well.
            playerEntity.removeStatusEffect(MedicEffects.HBRECOVERY);
            playerEntity.removeStatusEffect(MedicEffects.CRECOVERY);
            playerEntity.removeStatusEffect(MedicEffects.BFRECOVERY);
            playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 3600, 2));
            itemStack.decrement(1);
            return TypedActionResult.consume(itemStack);
        }
        return TypedActionResult.fail(playerEntity.getStackInHand(hand));
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if(entity.getHealth() < entity.getMaxHealth()){
            ItemStack itemStack = user.getStackInHand(hand);
            entity.playSound(SoundEvents.ITEM_BOOK_PUT, 1.0F, 0.5F);
            double healAmount = entity .getMaxHealth() * 1.0;
            entity.heal((float) healAmount);
            // Remove Injury
            entity.removeStatusEffect(MedicEffects.BLEEDING);
            entity.removeStatusEffect(MedicEffects.HEAVYBLEEDING);
            entity.removeStatusEffect(MedicEffects.CRIPPLED);
            entity.removeStatusEffect(MedicEffects.HEATSTROKE);
            entity.removeStatusEffect(MedicEffects.FROSTBITE);
            // Remove Recoveries.
            entity.removeStatusEffect(MedicEffects.HBRECOVERY);
            entity.removeStatusEffect(MedicEffects.CRECOVERY);
            entity.removeStatusEffect(MedicEffects.BFRECOVERY);
            // And remove Side Effects
            entity.removeStatusEffect(StatusEffects.NAUSEA);
            entity.removeStatusEffect(StatusEffects.WEAKNESS);
            entity.removeStatusEffect(StatusEffects.SLOWNESS);
            entity.removeStatusEffect(StatusEffects.MINING_FATIGUE);
            // Lastly, Add Absorption.
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 3600, 2));
            itemStack.decrement(1);
            return ActionResult.CONSUME;
        }
        return ActionResult.PASS;
    }
}
