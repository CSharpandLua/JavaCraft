package com.trf.javacraft.computers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.Callable;

import javax.script.ScriptException;

import com.trf.javacraft.Main;
import com.trf.javacraft.gui.ComGui;
import com.trf.javacraft.gui.Str;
import com.trf.javacraft.util.*;

import bsh.EvalError;
import net.minecraft.util.ResourceLocation;

abstract class Func {
	abstract void Main();
}

public class Computer {
	public int Id = 1;
	
	public CoreRunner core = new CoreRunner(this);
	
	public ComGui ThisGui;
	
	public Directory root = new Directory("/");
	
	public String OSCore ="/BeanOS/OSMain.bsh";
	
	public Func OSMain;
	
	public void LoadMain() throws FileNotFoundException, EvalError
	{
		core.env.eval(new FileReader(Main.class.getResource(OSCore).getPath()));
		core.env.eval("Main()");
	}
	
	// Loads libraries into CoreRunner instance
	public Computer()
	{
			try
			{
				core.LoadLibs();
			}
			catch (EvalError e) {}
	}

	// TODO Add better split function
	
	/**
	 * Executes a terminal command on this computer
	 * 
	 * Internally Calls CoreRunner.Eval
	 * @param cmd Command To Run
	 */
	@Deprecated
	public void Exec(String cmd)
	{
		String[] strs = cmd.split(" ");
		System.out.println("CMD: " + cmd);
		System.out.println("ISECHO: " + strs[0].equals("echo"));
		if (strs[0].equals("echo"))
		{
			try
			{
				core.Exec("TermWrite(\"" + strs[1] + "\");");
			} catch (EvalError e) {}
			
			return;
		}
		
		if (strs[0].equals("bean")) 
		{
				try
				{
					core.Exec(strs[1]);
				} catch (EvalError e) {
					ThisGui.Write("Error!");
				}
				
				return;
		}
		
		if (strs[0].equals("edit"))
		{
			ThisGui.infile = true;
			ThisGui.Buffer.StrList.clear();
			ThisGui.CurFileName = strs[1];
			return;
		}
		
		try
		{
			core.Exec("TermWrite(\"" + "Unknown Command" + "\")");
		} catch (EvalError e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
}
