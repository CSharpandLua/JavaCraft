package com.trf.javacraft.util.handlers;

import com.trf.javacraft.Main;
import com.trf.javacraft.blocks.*;
import com.trf.javacraft.items.HasModel;
import com.trf.javacraft.items.*;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler
{
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> ev) {
		ev.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[1]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> ev) {
		Main.instance.cout.info("Yeah!");
		ev.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[1]));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent ev) {
		for (Item i : ModItems.ITEMS)
		{
			if (i instanceof HasModel)
			{
				((BaseItem) i).registerModels();
			}
		}
		
		for (Block b : ModBlocks.BLOCKS)
		{
			if (b instanceof HasModel)
			{
				((BaseBlock) b).registerModels();
			}
		}
	}
}
