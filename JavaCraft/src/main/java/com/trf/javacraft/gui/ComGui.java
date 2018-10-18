package com.trf.javacraft.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ResourceLocation;

/**
 * 
 * Computer GUI Handler
 *
 */
public class ComGui extends GuiScreen {
	
	int topx = height / 2 - 260 / 2 + 10;
	int topy = (width / 2 - 260 / 2) + 300;
	final int LINE = 30;
	int Line = topy; 
	String CurLine = "";
	boolean end = false;
	
	protected void keyTyped(char par1, int par2) throws IOException
    {
		if (par2 == Keyboard.KEY_RETURN) {
			end = true;
			return;
		}
        CurLine += par1;
    }
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTime) {
		drawDefaultBackground();
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("jc", "textures/com.png"));
		drawTexturedModalRect(width / 2 - 260 / 2, height / 2 - 260 / 2, 0, 0, 260, 260);
		this.drawHoveringText(CurLine, topx, topy + Line);
		if (end) {
			end = false;
			CurLine = "";
			Line += LINE;
		}
		super.drawScreen(mouseX, mouseY, partialTime);
	}
	
	@Override
	public void initGui() {
		super.initGui();
	}
	
}