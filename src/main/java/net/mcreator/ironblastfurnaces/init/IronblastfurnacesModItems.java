/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ironblastfurnaces.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.ironblastfurnaces.item.CopperPickaxeItem;
import net.mcreator.ironblastfurnaces.item.CopperItem;
import net.mcreator.ironblastfurnaces.IronblastfurnacesMod;

public class IronblastfurnacesModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(IronblastfurnacesMod.MODID);
	public static final DeferredItem<Item> KILN;
	public static final DeferredItem<Item> COPPER_PICKAXE;
	public static final DeferredItem<Item> COPPER_HELMET;
	public static final DeferredItem<Item> COPPER_CHESTPLATE;
	public static final DeferredItem<Item> COPPER_LEGGINGS;
	public static final DeferredItem<Item> COPPER_BOOTS;
	static {
		KILN = block(IronblastfurnacesModBlocks.KILN);
		COPPER_PICKAXE = REGISTRY.register("copper_pickaxe", CopperPickaxeItem::new);
		COPPER_HELMET = REGISTRY.register("copper_helmet", CopperItem.Helmet::new);
		COPPER_CHESTPLATE = REGISTRY.register("copper_chestplate", CopperItem.Chestplate::new);
		COPPER_LEGGINGS = REGISTRY.register("copper_leggings", CopperItem.Leggings::new);
		COPPER_BOOTS = REGISTRY.register("copper_boots", CopperItem.Boots::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}