package demo.client;

import demo.Main;
import demo.common.ModRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class RenderRegistry {
	
	
	public static void registerItems() {
		
		reg(ModRegistry.chestplacer_item);
		
	}
	
	public static void reg(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register
		(item, 0, new ModelResourceLocation(Main.PATH + item.getUnlocalizedName().substring(5), "inventory"));
	}

}
