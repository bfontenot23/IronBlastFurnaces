/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ironblastfurnaces.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.ironblastfurnaces.IronblastfurnacesMod;

@EventBusSubscriber
public class IronblastfurnacesModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IronblastfurnacesMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> IRON_BLAST_FURNACES = REGISTRY.register("iron_blast_furnaces",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.ironblastfurnaces.iron_blast_furnaces")).icon(() -> new ItemStack(Blocks.FURNACE)).displayItems((parameters, tabData) -> {
				tabData.accept(IronblastfurnacesModBlocks.KILN.get().asItem());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(IronblastfurnacesModItems.COPPER_PICKAXE.get());
		}
	}
}