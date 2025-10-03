package net.otherheaven.medic.itemRegistry;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.otherheaven.medic.Medic;
import net.otherheaven.medic.itemRegistry.medicItemFunctions.*;

// Item Register
public class MedicItems {
    public static final Item BANDAGE = registerItem("bandage", new BandageItem(new Item.Settings()));
    public static final Item PLASTER = registerItem("plaster", new PlasterItem(new Item.Settings()));
    public static final Item ELIXIR = registerItem("elixir", new Item(new Item.Settings()));
    public static final Item ELIXIR_PATCH = registerItem("elixir_patch", new Item(new Item.Settings()));
    public static final Item MED_KIT = registerItem("med_kit", new MedKitItem(new Item.Settings()));
    public static final Item PAINKILLERS = registerItem("painkillers", new Item(new Item.Settings()));
    public static final Item SALVE = registerItem("salve", new SalveItem(new Item.Settings()));
    public static final Item SPLINT = registerItem("splint", new SplintItem(new Item.Settings()));

private static Item registerItem(String name, Item item){
    return Registry.register(Registries.ITEM, Identifier.of(Medic.MOD_ID, name), item);
}
    public static void registerMedicItems(){
        Medic.LOGGER.info("Initializing " + Medic.MOD_ID + "items...");
        }
    }

