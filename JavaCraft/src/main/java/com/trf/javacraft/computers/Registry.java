package com.trf.javacraft.computers;

import java.util.ArrayList;
import java.util.List;

import com.trf.javacraft.gui.ComGui;

public class Registry {
	
	private static List<Computer> coms = new ArrayList<Computer>();
	private static List<ComGui> guis = new ArrayList<ComGui>();
	private static List<FrameBuffer> bufs = new ArrayList<FrameBuffer>();
	
	public static String $Out = "";
	
	
	/**
	 * Adds a computer to the registry
	 * @param c The computer to add
	 */
	public static void AddComputer(Computer c)
	{
		if (GetComputer(c.Id) != null)
			return;
		
		coms.add(c);
	}
	
	/**
	 * Adds a new FrameBuffer
	 * @param buf FrameBuffer to be added
	 */
	public static void AddBuf(FrameBuffer buf) {
		bufs.add(buf);
	}
	
	/**
	 * Returns a FrameBuffer with a computer id
	 * @param id Computer id of FrameBuffer to remove
	 */
	public static FrameBuffer GetBuf(int id)
	{
		for (FrameBuffer f : bufs)
		{
			if (f.ID == id)
			{
				return f;
			}
		}
		
		return null;
	}
	
	/**
	 * Returns a ComGui with a computer id
	 * @param id Computer id of ComGui to retrieve
	 */
	public static ComGui GetGui(int id)
	{
		for (ComGui c : guis)
		{
			if (c.c.Id == id)
			{
				return c;
			}
		}
		
		return null;
	}
	
	/**
	 * Adds a ComGui
	 * @param id Computer id of FrameBuffer to remove
	 */
	public static void AddGui(ComGui com)
	{
		guis.add(com);
	}
	
	/**
	 * Returns a computer from the registry
	 * @param id id of the computer to get
	 * @return a Computer
	 */
	public static Computer GetComputer(int id)
	{
		for (Computer c : coms)
		{
			if (c.Id == id)
			{
				return c;
			}
		}
		
		return null;
	}
}
