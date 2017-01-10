package demo.common;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTableList;
import demo.Main;
/** https://github.com/Choonster/TestMod3/blob/7d877920df256a11d7797178addd8d9d32cf92c7/src/main/java/choonster/testmod3/init/ModLootTables.java **/

/** Registration and reference for new loot tables **/
public class ModLootTables {
	
	public static final ResourceLocation Custom_Chest_Loot = register("Custom_Chest_Loot");

	
	private static ResourceLocation register(String id) {
		return LootTableList.register(new ResourceLocation(Main.MODID, id));
	}
}
