package net.mcreator.ironblastfurnaces.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.ironblastfurnaces.jei_recipes.KilnSmeltingRecipe;
import net.mcreator.ironblastfurnaces.jei_recipes.CopperBlastFurnaceSmeltingRecipe;

@EventBusSubscriber
public class IronblastfurnacesModRecipeTypes {
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, "ironblastfurnaces");
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, "ironblastfurnaces");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = ModList.get().getModContainerById("ironblastfurnaces").get().getEventBus();
		event.enqueueWork(() -> {
			RECIPE_TYPES.register(bus);
			SERIALIZERS.register(bus);
			RECIPE_TYPES.register("kiln_smelting", () -> KilnSmeltingRecipe.Type.INSTANCE);
			SERIALIZERS.register("kiln_smelting", () -> KilnSmeltingRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("copper_blast_furnace_smelting", () -> CopperBlastFurnaceSmeltingRecipe.Type.INSTANCE);
			SERIALIZERS.register("copper_blast_furnace_smelting", () -> CopperBlastFurnaceSmeltingRecipe.Serializer.INSTANCE);
		});
	}
}