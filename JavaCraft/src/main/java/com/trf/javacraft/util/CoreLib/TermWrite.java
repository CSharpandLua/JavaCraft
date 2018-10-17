package com.trf.javacraft.util.CoreLib;

import java.util.function.Consumer;

import com.trf.javacraft.util.ScriptFunc;

public class TermWrite extends ScriptFunc {

	public String name = "TermWrite";
	
	public static void call(String str) {
		
	}
			
	public Object GetFunc() {
		return (Consumer<String>) TermWrite::call;
	}
	
}
