package net.otherheaven.medic.itemRegistry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.otherheaven.medic.Medic;

public class MedicItemGroups {
    public static final ItemGroup MEDIC_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,Identifier.of(Medic.MOD_ID, "medic_items"),FabricItemGroup.builder().icon(() -> new ItemStack(MedicItems.MED_KIT)).displayName(Text.translatable("itemgroup.medic.medic_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(MedicItems.BANDAGE);
                        entries.add(MedicItems.PLASTER);
                        entries.add(MedicItems.ELIXIR);
                        entries.add(MedicItems.ELIXIR_PATCH);
                        entries.add(MedicItems.MED_KIT);
                        entries.add(MedicItems.SALVE);
                        entries.add(MedicItems.SPLINT);
                        entries.add(MedicItems.PAINKILLERS);
                    }).build());

    public static void registerItemGroups() {
        Medic.LOGGER.info("Initializing" + Medic.MOD_ID + "Item Groups");
    }
}
