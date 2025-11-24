package net.mcreator.ironblastfurnaces.init;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.ironblastfurnaces.jei_recipes.KilnSmeltingRecipeCategory;
import net.mcreator.ironblastfurnaces.jei_recipes.KilnSmeltingRecipe;
import net.mcreator.ironblastfurnaces.jei_recipes.CopperBlastFurnaceSmeltingRecipeCategory;
import net.mcreator.ironblastfurnaces.jei_recipes.CopperBlastFurnaceSmeltingRecipe;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.stream.Collectors;
import java.util.Objects;
import java.util.List;

@JeiPlugin
public class IronblastfurnacesModJeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<KilnSmeltingRecipe> KilnSmelting_Type = new mezz.jei.api.recipe.RecipeType<>(KilnSmeltingRecipeCategory.UID, KilnSmeltingRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<CopperBlastFurnaceSmeltingRecipe> CopperBlastFurnaceSmelting_Type = new mezz.jei.api.recipe.RecipeType<>(CopperBlastFurnaceSmeltingRecipeCategory.UID, CopperBlastFurnaceSmeltingRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return ResourceLocation.parse("ironblastfurnaces:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new KilnSmeltingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new CopperBlastFurnaceSmeltingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<KilnSmeltingRecipe> KilnSmeltingRecipes = recipeManager.getAllRecipesFor(KilnSmeltingRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(KilnSmelting_Type, KilnSmeltingRecipes);
		List<CopperBlastFurnaceSmeltingRecipe> CopperBlastFurnaceSmeltingRecipes = recipeManager.getAllRecipesFor(CopperBlastFurnaceSmeltingRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(CopperBlastFurnaceSmelting_Type, CopperBlastFurnaceSmeltingRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(IronblastfurnacesModBlocks.KILN.get().asItem()), KilnSmelting_Type);
		registration.addRecipeCatalyst(new ItemStack(IronblastfurnacesModBlocks.COPPER_BLAST_FURNACE.get().asItem()), CopperBlastFurnaceSmelting_Type);
	}
}