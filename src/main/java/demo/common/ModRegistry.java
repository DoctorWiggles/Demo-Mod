package demo.common;

import demo.items.Chest_Placer_Item;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRegistry {
	
	public static Item chestplacer_item;

	public static void registerItems() {
		
		reg(chestplacer_item = new Chest_Placer_Item("chestplacer_item"));
		
	}

	
	
	public static void reg(Item item){
		
		item.setRegistryName(item.getUnlocalizedName().substring(5));
		GameRegistry.register(item);
	}
	
}
