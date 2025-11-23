package net.mcreator.ironblastfurnaces.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.ironblastfurnaces.world.inventory.KilnGuiMenu;
import net.mcreator.ironblastfurnaces.procedures.ProgressLevelIndicatorProcedure;
import net.mcreator.ironblastfurnaces.procedures.FuelLevelIndicatorProcedure;
import net.mcreator.ironblastfurnaces.init.IronblastfurnacesModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class KilnGuiScreen extends AbstractContainerScreen<KilnGuiMenu> implements IronblastfurnacesModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;

	public KilnGuiScreen(KilnGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("ironblastfurnaces:textures/screens/kiln_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(ResourceLocation.parse("ironblastfurnaces:textures/screens/bigslot.png"), this.leftPos + 105, this.topPos + 30, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(ResourceLocation.parse("ironblastfurnaces:textures/screens/progressarrow.png"), this.leftPos + 77, this.topPos + 35, Mth.clamp((int) ProgressLevelIndicatorProcedure.execute(world, x, y, z) * 22, 0, 484), 0, 22, 16, 506, 16);
		guiGraphics.blit(ResourceLocation.parse("ironblastfurnaces:textures/screens/fuel.png"), this.leftPos + 55, this.topPos + 36, Mth.clamp((int) FuelLevelIndicatorProcedure.execute(world, x, y, z) * 14, 0, 182), 0, 14, 14, 196, 14);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.ironblastfurnaces.kiln_gui.label_kiln"), 77, 6, -13421773, false);
	}

	@Override
	public void init() {
		super.init();
	}
}