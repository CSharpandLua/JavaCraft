package com.trf.javacraft.computers;

import java.util.ArrayList;
import java.util.List;

public class Directory {

	public List<File> files = new ArrayList<File>();
	
	public String Path;
	
	public File GetFile(String name)
	{
		for (File f : files)
		{
			if (f.name == name)
				return f;
		}
		
		return null;
	}
	
	public void AddFile(File f)
	{
		files.add(f);
	}
	
	public Directory(String p)
	{
		Path = p;
	}
	
}
