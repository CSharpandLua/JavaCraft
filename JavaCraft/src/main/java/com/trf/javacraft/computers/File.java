package com.trf.javacraft.computers;

import java.util.List;

import com.trf.javacraft.gui.Str;

public class File {
	public String name;
	public String rawContent;
	
	/**
	 * Buffer of what to show on screen
	 */
	public List<Str> Buf;
	
	public File(String na, String cont) {
		name = na;
		rawContent = cont;
	}

	public File(String na, List<Str> f) {
		name = na;
		Buf = f;
	}
}
