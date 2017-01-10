package demo;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import demo.events.ModEventHandler;


@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main {
	
	public static final String MODID = "demo";
	public static final String PATH = MODID + ":";
	public static final String MODNAME = "DemonstrationMod";
	public static final String VERSION = "v1.0";
	public static final Logger logger = LogManager.getLogger(Main.MODID);

	public static ModEventHandler Modevents = new ModEventHandler();
	
	@Instance
	public static Main instance = new Main();
	
	
	//Proxy Sorting
	@SidedProxy(clientSide="demo.ClientProxy", serverSide="demo.CommonProxy")
	public static CommonProxy proxy;
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {		
		proxy.preInit(e);
		
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
			
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}
	
			
}
