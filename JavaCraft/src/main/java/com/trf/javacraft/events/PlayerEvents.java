package com.trf.javacraft.events;

import com.trf.javacraft.Main;
import com.trf.javacraft.blocks.ModBlocks;
import com.trf.javacraft.items.HasModel;
import com.trf.javacraft.items.ModItems;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;

public class PlayerEvents {

	@SubscribeEvent
	public void OnPlayerJoin(PlayerRespawnEvent ev) {
		System.out.println("Player Respawned\n");
		Minecraft m = Minecraft.getMinecraft();
		m.player.sendMessage(new TextComponentString("Hello Player!"));
		m.player.sendChatMessage("End!");
	}
	
	@SubscribeEvent
	public void onItemRegister(RegistryEvent.Register<Item> ev) {
		ev.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public void onBlockRegister(RegistryEvent.Register<Block> ev) {
		Main.instance.cout.info("Yeah!");
		ev.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
	}
	
	@SubscribeEvent
	public void onModelRegister(ModelRegistryEvent ev) {
		for (Item i : ModItems.ITEMS)
		{
			if (i instanceof HasModel)
			{
				((HasModel) i).registerModels();
			}
		}
		
		for (Block b : ModBlocks.BLOCKS)
		{
			if (b instanceof HasModel)
			{
				((HasModel) b).registerModels();
			}
		}
	}
	
}
