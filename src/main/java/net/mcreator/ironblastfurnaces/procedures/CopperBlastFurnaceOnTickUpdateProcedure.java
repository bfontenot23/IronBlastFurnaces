package net.mcreator.ironblastfurnaces.procedures;

import org.checkerframework.checker.units.qual.s;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.NonNullList;
import net.minecraft.core.BlockPos;

import net.mcreator.ironblastfurnaces.jei_recipes.CopperBlastFurnaceSmeltingRecipe;

import java.util.stream.Collectors;
import java.util.List;

public class CopperBlastFurnaceOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		double inputCooktime = 0;
		double recipeStringCounter = 0;
		double inputExp = 0;
		if (!((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Blocks.AIR.asItem())) {
			if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() > 0 && !((new Object() {
				public ItemStack getResult() {
					if (world instanceof Level _lvl) {
						net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
						List<CopperBlastFurnaceSmeltingRecipe> recipes = rm.getAllRecipesFor(CopperBlastFurnaceSmeltingRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
						for (CopperBlastFurnaceSmeltingRecipe recipe : recipes) {
							NonNullList<Ingredient> ingredients = recipe.getIngredients();
							if (!ingredients.get(0).test((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy())))
								continue;
							return recipe.getResultItems().get(0).copy();
						}
					}
					return ItemStack.EMPTY;
				}
			}.getResult()).getItem() == Blocks.AIR.asItem()) && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64 && ((new Object() {
				public ItemStack getResult() {
					if (world instanceof Level _lvl) {
						net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
						List<CopperBlastFurnaceSmeltingRecipe> recipes = rm.getAllRecipesFor(CopperBlastFurnaceSmeltingRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
						for (CopperBlastFurnaceSmeltingRecipe recipe : recipes) {
							NonNullList<Ingredient> ingredients = recipe.getIngredients();
							if (!ingredients.get(0).test((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy())))
								continue;
							return recipe.getResultItems().get(0).copy();
						}
					}
					return ItemStack.EMPTY;
				}
			}.getResult()).getItem() == (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() || 0 == itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount())) {
				{
					if (world instanceof Level _lvl) {
						net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
						List<CopperBlastFurnaceSmeltingRecipe> recipes = rm.getAllRecipesFor(CopperBlastFurnaceSmeltingRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
						for (CopperBlastFurnaceSmeltingRecipe recipe : recipes) {
							List<Ingredient> ingredients = recipe.getIngredients();
							if (!ingredients.get(0).test((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy())))
								continue;
							List<ItemStack> reciperesult = recipe.getResultItems();
							recipeStringCounter = 0;
							for (String stringiterator : recipe.strings()) {
								if (recipeStringCounter == 1) {
									inputExp = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator);
								}
								if (recipeStringCounter == 0) {
									inputCooktime = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator);
									recipeStringCounter = 1;
								}
							}
							break;
						}
					}
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("maxSmeltTime", inputCooktime);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getBurnTime(null) > 0 && 0 >= getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fuelTicks")) {
					if (!(blockstate.getBlock().getStateDefinition().getProperty("lit") instanceof BooleanProperty _getbp22 && blockstate.getValue(_getbp22))) {
						{
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("lit") instanceof BooleanProperty _booleanProp)
								world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
						}
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("maxSmeltTime", inputCooktime);
							_blockEntity.getPersistentData().putDouble("fuelTicks", ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getBurnTime(null)));
							_blockEntity.getPersistentData().putDouble("currentMaxFuel", ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getBurnTime(null)));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						int _slotid = 1;
						ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
						_stk.shrink(1);
						_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
					}
				}
				if (0 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fuelTicks")) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("smeltingTime", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "smeltingTime") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "smeltingTime") >= inputCooktime) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("smeltingTime", 0);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = (new Object() {
							public ItemStack getResult() {
								if (world instanceof Level _lvl) {
									net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
									List<CopperBlastFurnaceSmeltingRecipe> recipes = rm.getAllRecipesFor(CopperBlastFurnaceSmeltingRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
									for (CopperBlastFurnaceSmeltingRecipe recipe : recipes) {
										NonNullList<Ingredient> ingredients = recipe.getIngredients();
										if (!ingredients.get(0).test((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy())))
											continue;
										return recipe.getResultItems().get(0).copy();
									}
								}
								return ItemStack.EMPTY;
							}
						}.getResult()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						int _slotid = 0;
						ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
						_stk.shrink(1);
						_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("storedExp", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "storedExp") + inputExp));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
		} else {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("smeltingTime", 0);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fuelTicks") > 0) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("fuelTicks", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fuelTicks") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fuelTicks") > 0) {
			if (Mth.nextInt(RandomSource.create(), 1, 30) == 1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.blastfurnace.fire_crackle")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.blastfurnace.fire_crackle")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			}
		} else {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("smeltingTime", 0);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (blockstate.getBlock().getStateDefinition().getProperty("lit") instanceof BooleanProperty _getbp53 && blockstate.getValue(_getbp53)) {
				{
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("lit") instanceof BooleanProperty _booleanProp)
						world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
				}
			}
		}
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}