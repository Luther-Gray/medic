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
import net.otherheaven.medic.Medic;
import net.otherheaven.medic.effectRegistry.MedicEffects;

public class PlasterItem extends Item {
//    You can stack 8 of these mfs
    public PlasterItem(Settings settings) {
        super(settings.maxCount(8));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        if(playerEntity.getHealth() < playerEntity.getMaxHealth()){
            ItemStack itemStack = playerEntity.getStackInHand(hand);
            playerEntity.playSound(SoundEvents.ITEM_BOOK_PUT, 1.0F, 0.5F);
            double healAmount = playerEntity.getMaxHealth() * 0.30;
            playerEntity.heal((float) healAmount);
            playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1, false, true));
            if (playerEntity.hasStatusEffect(MedicEffects.BLEEDING) || playerEntity.hasStatusEffect(MedicEffects.HEAVYBLEEDING)) {
                playerEntity.removeStatusEffect(MedicEffects.BLEEDING);
                playerEntity.removeStatusEffect(MedicEffects.HEAVYBLEEDING);
                playerEntity.addStatusEffect(new StatusEffectInstance(MedicEffects.HBRECOVERY, 3600, 0));
            }
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
            double healAmount = entity .getMaxHealth() * 0.30;
            entity.heal((float) healAmount);
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1, false, true));
            if (entity.hasStatusEffect(MedicEffects.BLEEDING) || entity.hasStatusEffect(MedicEffects.HEAVYBLEEDING)) {
                entity.removeStatusEffect(MedicEffects.BLEEDING);
                entity.removeStatusEffect(MedicEffects.HEAVYBLEEDING);
            }
            itemStack.decrement(1);
            return ActionResult.CONSUME;
        }
        return ActionResult.PASS;
    }
}
