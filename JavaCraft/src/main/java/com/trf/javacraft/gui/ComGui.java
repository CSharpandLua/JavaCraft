package com.trf.javacraft.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptException;

import org.lwjgl.input.Keyboard;

import com.trf.javacraft.Main;
import com.trf.javacraft.computers.Computer;
import com.trf.javacraft.computers.File;
import com.trf.javacraft.computers.FrameBuffer;
import com.trf.javacraft.computers.Registry;

import bsh.EvalError;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ResourceLocation;

class TextBox extends GuiTextField {
	
	public TextBox(int p_i45542_1_, FontRenderer p_i45542_2_, int p_i45542_3_, int p_i45542_4_, int p_i45542_5_,
			int p_i45542_6_) {
		super(p_i45542_1_, p_i45542_2_, p_i45542_3_, p_i45542_4_, p_i45542_5_, p_i45542_6_);
	}

	public boolean end = false;
	
	@Override
	public boolean textboxKeyTyped(char key, int keycode)
	{
		
		if (keycode == Keyboard.KEY_RETURN)
		{
			end = true;
		}
		
		return super.textboxKeyTyped(key, keycode);
	}
}

/**
 * 
 * Computer GUI Handler
 *
 */
public class ComGui extends GuiScreen {
	
	int topx = height / 2 - 260 / 2 + 215;
	public int topy = ((width / 2 - 260 / 2) + 140);
	public final int LINE = 19;
	public int Line = topy; 
	String CurLine = "";
	boolean end = false;
	public boolean infile = false;
	public int fline = 0;
	public final Computer c; // The computer instance associated with this GUI
	public String CurFileName;
	public boolean Reading = false;
	/**
	 * Ran when a key is typed
	 */
	protected void keyTyped(char par1, int par2) throws IOException
    {
		
		if (par2 == Keyboard.KEY_ESCAPE)
		{
			super.keyTyped(par1, par2);
		}
		
		if (par2 == Keyboard.KEY_LSHIFT || par2 == Keyboard.KEY_RSHIFT)
		{
			return;
		}
		
		if (par2 == Keyboard.KEY_RETURN)
		{
			end = true;
			
			if (infile)
			{
				infile = false;
				Line = topy;
				Buffer.StrList.clear();
				c.root.AddFile(new File(CurFileName, CurFile));
			}
			
			return;
		}
		
		if (infile)
		{
			if (par2 == Keyboard.KEY_UP)
			{
				if (fline > 0)
				{
					fline--;
					in.setText(Buffer.Get(fline).data);
				}
			}
			
			if (par2 == Keyboard.KEY_DOWN)
			{
				if (fline < Buffer.StrList.size())
				{
					fline++;
					in.setText(Buffer.Get(fline).data);
				}
			}
		}
		
		in.textboxKeyTyped(par1, par2);
    }
	
	/**
	 * A List of Objects that define content/line values to draw on screen
	 */
	@Deprecated
	public List<Str> framebuffer = new ArrayList<Str>();
	public FrameBuffer Buffer;
	
	private List<Str> CurFile = new ArrayList<Str>();
	private GuiTextField in;
	
	public void Write(String str)
	{
		Buffer.Write(new Str(str, Line));
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTime) {
		drawDefaultBackground();
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("jc", "textures/com.png"));
		drawTexturedModalRect(width / 2 - 260 / 2, height / 2 - 260 / 2, 0, 0, 260, 260);
		
		// Draw FrameBuffer
		for (Str s : Buffer.StrList) {
			this.fontRenderer.drawString(s.data, topx + 10, s.line, 0xffFFFFFF);
		}
			
		if (end)
		{
			
			if (infile)
			{
				CurFile.add(new Str(in.getText(), Line));
				Line += Line;
				super.drawScreen(mouseX, mouseY, partialTime);
				return;
			}
			
			end = false;
			
			Buffer.Write(new Str(">" + in.getText(), Line));
			
			Line += LINE;
			
			try {
				c.core.Exec("LineEntered(\"" + in.getText() +"\")");
			}
			catch (EvalError e) {
				Buffer.Write(new Str("OS-Error: " + e.getMessage(), Line));
			}
			
			Line += LINE;
			
			in.setText("");
		}
		
		in.drawTextBox();
		
		super.drawScreen(mouseX, mouseY, partialTime);
	}
	
	@Override
	public void initGui() {
		in = new GuiTextField(1, fontRenderer, topx, topy + 200, 260, 10);
		in.setCanLoseFocus(false);
		in.setEnabled(true);
		in.setEnableBackgroundDrawing(true);
		in.setVisible(true);
		in.setFocused(true);
		super.initGui();
	}
	
	public ComGui(Computer com)
	{
		c = com;
		
		if (Registry.GetBuf(c.Id) == null)
		{
			Buffer = new FrameBuffer(c.Id);
			Registry.AddBuf(Buffer);
		}
		else
		{
			Buffer = Registry.GetBuf(c.Id);
		}
	}
	
}