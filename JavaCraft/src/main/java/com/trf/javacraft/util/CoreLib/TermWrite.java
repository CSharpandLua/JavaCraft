package com.trf.javacraft.util.CoreLib;

import com.trf.javacraft.computers.*;
import com.trf.javacraft.gui.ComGui;
import com.trf.javacraft.gui.Str;
import bsh.*;

public class TermWrite {
	
	/**
	 * Writes a string to the connected computers framebuffer
	 * 
	 * if no computer is present, does nothing
	 * @param str String to write
	 * @throws EvalError 
	 */
	public static void invoke(Interpreter env, CallStack stk, String str) throws EvalError {
		
		ComGui c = Registry.GetComputer((int) env.get("_ID")).ThisGui;
		
		System.out.println("NULL: " + Boolean.toString(c == null));
		
		    
		if (c == null)
		{
			return;
		}
		
		System.out.println("STR: " + str);
		
		c.Buffer.Write(new Str(str, (int) env.get("_RENDERLINE")));
		
		System.out.println("Done.");
	}
	
	public TermWrite() {}
}