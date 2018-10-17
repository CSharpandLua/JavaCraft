package com.trf.javacraft.util;

import com.trf.javacraft.util.ScriptFunc;
// Runner with less permissions
public class UserRunner extends CoreRunner {

	@Override
	public void LoadLib(ScriptFunc lib) {
		throw new SecurityException("Cannot load libraries in a UserRunner instance");
	}
	
}
