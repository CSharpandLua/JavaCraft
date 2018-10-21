package com.trf.javacraft.computers;

import java.util.ArrayList;
import java.util.List;

import com.trf.javacraft.gui.Str;

public class FrameBuffer {
	public final int ID;
	public ArrayList<Str> StrList = new ArrayList<Str>();
	
	public void Write(Str s)
	{
		StrList.add(s);
	}
	
	public Str Get(int index)
	{
		return StrList.get(index);
	}
	
	public FrameBuffer(int id)
	{
		ID = id;
	}
	
}
