package com.trf.javacraft.util;

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
	private final Interpreter env = new Interpreter();
	
	public void LoadLibs() throws EvalError
	{
		env.eval("print(\"NOT NULL\")");
		env.eval("importCommands(\"com.trf.javacraft.util.CoreLib\")");
		env.set("print", null);
		env.set("importCommands", null);
		env.setNameSpace(new NameSpace(env.getClassManager(), "SandBox" + c.Id));
	}
	
	public void Exec(String code) throws EvalError
	{
			if (env.get("_ID") == null)
				env.set("_ID", c.Id);
			 
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
