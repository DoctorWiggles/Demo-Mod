package demo;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import demo.common.ModRegistry;


	
public class DemoTab extends CreativeTabs
	{
		public static DemoTab Tab = new DemoTab();
		
		public DemoTab()
		{		
			super(Main.MODNAME);
			
		}
		
		@Override
		public ItemStack getIconItemStack()
		{
			return new ItemStack(ModRegistry.chestplacer_item);
		}
		@Override
		public Item getTabIconItem() 
		{
			return ModRegistry.chestplacer_item;
		}
	}