/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ironblastfurnaces.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.ironblastfurnaces.block.KilnBlock;
import net.mcreator.ironblastfurnaces.IronblastfurnacesMod;

public class IronblastfurnacesModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(IronblastfurnacesMod.MODID);
	public static final DeferredBlock<Block> KILN;
	static {
		KILN = REGISTRY.register("kiln", KilnBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}