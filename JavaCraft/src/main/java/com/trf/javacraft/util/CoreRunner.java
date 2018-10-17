package com.trf.javacraft.util;

import javax.script.*;
import com.trf.javacraft.util.ScriptFunc;

// Runner that executes the javascript code with core permissions
public class CoreRunner {

	private final ScriptEngine eng;
	
	public void LoadLib(ScriptFunc lib) {
		eng.put(lib.name, lib.GetFunc());
	}
	
	public void Exec(String code) throws ScriptException {
		eng.eval(code);
	}
	
	public CoreRunner() {
		ScriptEngineManager factory = new ScriptEngineManager();
	    eng = factory.getEngineByName("JavaScript");
	}
	
}
