package com.trf.javacraft.computers;

import java.util.ArrayList;
import java.util.List;

public class Registry {
	
	private static List<Computer> coms = new ArrayList<Computer>();
	
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
