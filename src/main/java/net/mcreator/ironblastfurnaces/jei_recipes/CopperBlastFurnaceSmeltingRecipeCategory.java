package net.mcreator.ironblastfurnaces.jei_recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.NonNullList;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.ironblastfurnaces.init.IronblastfurnacesModJeiPlugin;
import net.mcreator.ironblastfurnaces.init.IronblastfurnacesModBlocks;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

import java.util.List;

public class CopperBlastFurnaceSmeltingRecipeCategory implements IRecipeCategory<CopperBlastFurnaceSmeltingRecipe> {
	public final static ResourceLocation UID = ResourceLocation.parse("ironblastfurnaces:copper_blast_furnace_smelting");
	public final static ResourceLocation TEXTURE = ResourceLocation.parse("ironblastfurnaces:textures/screens/furnace_jei.png");
	private final IDrawable background;
	private final IDrawable icon;
	private final Minecraft mc = Minecraft.getInstance();

	public CopperBlastFurnaceSmeltingRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 175, 85);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(IronblastfurnacesModBlocks.COPPER_BLAST_FURNACE.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<CopperBlastFurnaceSmeltingRecipe> getRecipeType() {
		return IronblastfurnacesModJeiPlugin.CopperBlastFurnaceSmelting_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Copper Blast Furnace Smelting");
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public int getWidth() {
		return this.background.getWidth();
	}

	@Override
	public int getHeight() {
		return this.background.getHeight();
	}

	@Override
	public void draw(CopperBlastFurnaceSmeltingRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.background.draw(guiGraphics);

		guiGraphics.blit(ResourceLocation.parse("ironblastfurnaces:textures/screens/fuelreverse.png"), 54, 34, 14 * ((mc.player.tickCount / 10) % 14) - 1, 0, 14, 14, 196, 14);

		guiGraphics.blit(ResourceLocation.parse("ironblastfurnaces:textures/screens/progressarrow.png"), 76, 33, 22 * ((mc.player.tickCount / 10) % 23) - 1, 0, 22, 16, 506, 16);

	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, CopperBlastFurnaceSmeltingRecipe recipe, IFocusGroup focuses) {
		List<ItemStack> recipeOutputs = recipe.getResultItems();
		List<ItemStack> actualOutputs = NonNullList.withSize(1, ItemStack.EMPTY);
		for (int i = 0; i < recipeOutputs.size(); i++) {
			actualOutputs.set(i, recipeOutputs.get(i));
		}
		builder.addSlot(RecipeIngredientRole.INPUT, 53, 17).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 110, 35).addItemStack(actualOutputs.get(0));
	}
}