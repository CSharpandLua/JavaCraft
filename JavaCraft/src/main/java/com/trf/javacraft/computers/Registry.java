package com.trf.javacraft.computers;

import java.util.ArrayList;
import java.util.List;

public class Registry {
	
	private static List<Computer> coms = new ArrayList<Computer>();
	
	public static String $Out = "";
	
	
	/**
	 * Adds a computer to the registry
	 * @param c The computer to add
	 */
	public static void AddComputer(Computer c)
	{
		coms.add(c);
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
