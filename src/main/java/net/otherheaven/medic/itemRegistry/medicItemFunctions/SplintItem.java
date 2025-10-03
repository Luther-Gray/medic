package net.otherheaven.medic.itemRegistry.medicItemFunctions;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.otherheaven.medic.effectRegistry.MedicEffects;

public class SplintItem extends Item {
//    You can stack 16 of these mfs
    public SplintItem(Settings settings) {
        super(settings.maxCount(16));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        if(playerEntity.getHealth() <= playerEntity.getMaxHealth()){
            ItemStack itemStack = playerEntity.getStackInHand(hand);
            playerEntity.playSound(SoundEvents.ITEM_BOOK_PUT, 1.0F, 0.5F);
            if (playerEntity.hasStatusEffect(MedicEffects.CRIPPLED)) {
                playerEntity.removeStatusEffect(MedicEffects.CRIPPLED);
                playerEntity.addStatusEffect(new StatusEffectInstance(MedicEffects.CRECOVERY, 900, 0));
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
            entity.playSound(SoundEvents.ITEM_BOOK_PUT, 1.0F, 0.5F);
            if (entity.hasStatusEffect(MedicEffects.CRIPPLED)) {
                entity.removeStatusEffect(MedicEffects.CRIPPLED);

            }
            itemStack.decrement(1);
            return ActionResult.CONSUME;
        }
        return ActionResult.PASS;
    }
}
