package demo;

import demo.common.ModRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	
	public void preInit(FMLPreInitializationEvent e) {		
		FMLCommonHandler.instance().bus().register(Main.Modevents);
    	MinecraftForge.EVENT_BUS.register(Main.Modevents);
    	
    	ModRegistry.registerItems();
		
	}

	public void init(FMLInitializationEvent e) {
		
	}

	public void postInit(FMLPostInitializationEvent e) {

	}
}
