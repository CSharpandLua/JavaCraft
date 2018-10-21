package com.trf.javacraft.util.CoreLib;

import com.trf.javacraft.computers.*;
import com.trf.javacraft.gui.ComGui;
import com.trf.javacraft.gui.Str;
import bsh.*;

public class TermClear {
	
	/**
	 * Writes a string to the connected computers framebuffer
	 * 
	 * if no computer is present, does nothing
	 * @param str String to write
	 * @throws EvalError 
	 */
	public static void invoke(Interpreter env, CallStack stk) throws EvalError {
		
		ComGui c = Registry.GetComputer((int) env.get("_ID")).ThisGui;
		    
		if (c == null)
		{
			return;
		}
		
		c.Line = c.topy;
		c.Buffer.StrList.clear();
	}
	
	public TermClear() {}
}