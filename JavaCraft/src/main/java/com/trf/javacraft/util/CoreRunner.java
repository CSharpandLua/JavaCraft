package com.trf.javacraft.util;

import java.io.FileReader;

import javax.script.*;

import com.trf.javacraft.Main;
import com.trf.javacraft.computers.Computer;
import com.trf.javacraft.util.CoreLib.*;

import bsh.EvalError;
import bsh.Interpreter;
import bsh.NameSpace;

// Runner that executes the javascript code with core permissions
public class CoreRunner {
	
	private final Computer c;
	public final Interpreter env = new Interpreter();
	
	public void LoadLibs() throws EvalError
	{
		env.set("_RENDERLINE", 0);
		env.eval("print(\"NOT NULL\")");
		env.eval("importCommands(\"com.trf.javacraft.util.CoreLib\")");
		env.unset("print");
		env.unset("importCommands");
	}
	
	public void Exec(String code) throws EvalError
	{
			if (env.get("_ID") == null)
				env.set("_ID", c.Id);
			
			env.set("_RENDERLINE", c.ThisGui.Line); // TODO Make this unnecessary
			 
			env.eval(code);
	}
	
	public void Exec(FileReader code) throws EvalError
	{
			if (env.get("_ID") == null)
				env.set("_ID", c.Id);
			
			env.set("_RENDERLINE", c.ThisGui.Line); // TODO Make this unnecessary
			 
			env.eval(code);
	}
	
	public CoreRunner()
	{
		c = null;
	}
	
	public CoreRunner(Computer com) {
		c = com;
	}
	
}
