package net.otherheaven.medic;


import net.fabricmc.api.ModInitializer;
import net.otherheaven.medic.effectRegistry.MedicEffects;
import net.otherheaven.medic.itemRegistry.MedicItemGroups;
import net.otherheaven.medic.itemRegistry.MedicItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Medic implements ModInitializer {
	public static final String MOD_ID = "medic";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		MedicItemGroups.registerItemGroups();
		MedicItems.registerMedicItems();
		MedicEffects.registerEffects();
	}
}