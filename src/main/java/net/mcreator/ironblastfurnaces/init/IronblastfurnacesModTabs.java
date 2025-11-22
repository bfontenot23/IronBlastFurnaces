/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ironblastfurnaces.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.ironblastfurnaces.IronblastfurnacesMod;

public class IronblastfurnacesModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IronblastfurnacesMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> IRON_BLAST_FURNACES = REGISTRY.register("iron_blast_furnaces",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.ironblastfurnaces.iron_blast_furnaces")).icon(() -> new ItemStack(Blocks.FURNACE)).displayItems((parameters, tabData) -> {
				tabData.accept(IronblastfurnacesModBlocks.KILN.get().asItem());
				tabData.accept(IronblastfurnacesModItems.COPPER_PICKAXE.get());
				tabData.accept(IronblastfurnacesModItems.COPPER_HELMET.get());
				tabData.accept(IronblastfurnacesModItems.COPPER_CHESTPLATE.get());
				tabData.accept(IronblastfurnacesModItems.COPPER_LEGGINGS.get());
				tabData.accept(IronblastfurnacesModItems.COPPER_BOOTS.get());
			}).build());
}