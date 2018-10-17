package com.trf.javacraft.blocks;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
	public static final List<Block> BLOCKS = new ArrayList<Block>(1);
	
	public static final Block COM_BLOCK = new BaseBlock("computer", Material.IRON);
}
