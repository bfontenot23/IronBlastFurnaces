package net.mcreator.ironblastfurnaces.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class ProgressLevelIndicatorProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		double progress = 0;
		double clamped = 0;
		double frame = 0;
		progress = getBlockNBTNumber(world, BlockPos.containing(x, y, z), "smeltingTime") / getBlockNBTNumber(world, BlockPos.containing(x, y, z), "maxSmeltTime");
		clamped = Math.max(0, Math.min(1, progress));
		frame = Math.floor(clamped * 23);
		return Math.max(0, Math.min(23, frame));
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}