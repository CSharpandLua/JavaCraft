package com.trf.javacraft.computers;

import javax.script.ScriptException;

import com.trf.javacraft.gui.ComGui;
import com.trf.javacraft.gui.Str;
import com.trf.javacraft.util.*;

import bsh.EvalError;

public class Computer {
	public int Id = 1;
	
	public CoreRunner core = new CoreRunner(this);
	
	public ComGui ThisGui;
	
	public Directory root = new Directory("/");
	
	// Loads libraries into CoreRunner instance
	public Computer()
	{
			try
			{
				core.LoadLibs();
			}
			catch (EvalError e) {}
	}
	
	public void Write(String str)
	{
		System.out.print("WROTE: " + str);
		ThisGui.FrameBuffer.add(new Str(str, ThisGui.Line));
		ThisGui.Line += ThisGui.LINE;
	}

	// TODO Add better split function
	
	/**
	 * Executes a terminal command on this computer
	 * 
	 * Internally Calls CoreRunner.Eval
	 * @param cmd Command To Run
	 */
	public void Exec(String cmd)
	{
		String[] strs = cmd.split(" ");
		System.out.println("CMD: " + cmd);
		
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
					Write("Error!");
				}
				
				return;
		}
		
		if (strs[0].equals("edit"))
		{
			ThisGui.infile = true;
			ThisGui.FrameBuffer.clear();
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
