package com.trf.javacraft.computers;

import javax.script.ScriptException;

import com.trf.javacraft.util.*;

public class Computer {
	public int Id;
	
	public CoreRunner core = new CoreRunner();
	
	/**
	 * Executes a terminal command on this computer
	 * 
	 * Internally Calls CoreRunner.Eval
	 * @param cmd Command To Run
	 */
	public void Exec(String cmd) throws ScriptException
	{
		String[] strs = cmd.split(" ");
		
		if (strs[0] == "echo")
		{
			core.Exec("TermWrite('" + strs[1] + "')");
		}
	}
}
