/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ironblastfurnaces.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.ironblastfurnaces.client.gui.KilnGuiScreen;
import net.mcreator.ironblastfurnaces.client.gui.CopperBlastFurnaceGuiScreen;

@EventBusSubscriber(Dist.CLIENT)
public class IronblastfurnacesModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(IronblastfurnacesModMenus.KILN_GUI.get(), KilnGuiScreen::new);
		event.register(IronblastfurnacesModMenus.COPPER_BLAST_FURNACE_GUI.get(), CopperBlastFurnaceGuiScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}