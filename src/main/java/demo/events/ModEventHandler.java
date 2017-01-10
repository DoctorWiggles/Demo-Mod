package demo.events;

import java.util.List;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import demo.Main;

/**https://github.com/Vazkii/Botania/blob/master/src/main/java/vazkii/botania/common/core/loot/LootHandler.java**/
public class ModEventHandler { 
		
	@SubscribeEvent
	public void Table_Additives(LootTableLoadEvent event){		
		
		/*Name of the table*/
		String name = event.getName().toString();
		
		try{
			
			/*Loot tables to match*/
			if(name.matches("minecraft:chests/spawn_bonus_chest") 
				|| name.matches("minecraft:entities/chicken")){	
				
				Main.logger.info("Matched our targets");
				Main.logger.info("vvvvv");
				
				/*Adding a loot pool to the target table*/
				event.getTable().addPool(getAdditive("demo:Loot_Additive"));
			}
			
			/*Finding and adding to non mincraft loot*/
			if(name.matches("demo:Custom_Chest_Loot")){				
				
				Main.logger.info("Found our own loot");
				Main.logger.info("vvvvv");
			}
			
			/*Display Loot Tables that get loaded*/
			Main.logger.info(name);		
		}
		catch(Exception exc){
		}
		
	}
	
	/** Here we are creating a new pool from the resource location we feed it. **/
	private LootPool getAdditive(String entryName) {
		return new LootPool(new LootEntry[] { getAdditiveEntry(entryName, 1) }, new LootCondition[0], new RandomValueRange(1), new RandomValueRange(0, 1), "Additive_pool");
	}

	/** Make sure to setup your resource location accordingly **/
	private LootEntryTable getAdditiveEntry(String name, int weight) {
		return new LootEntryTable(new ResourceLocation(name), weight, 0, new LootCondition[0], "Additive_entry");
	}

	
}