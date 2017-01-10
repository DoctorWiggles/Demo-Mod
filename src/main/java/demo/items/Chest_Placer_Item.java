package demo.items;

import java.util.List;
import java.util.Random;

import demo.DemoTab;
import demo.Main;
import demo.common.ModLootTables;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

public class Chest_Placer_Item extends Item{

	
	public Chest_Placer_Item(String unlocalizedName){
		super();
		this.setUnlocalizedName(unlocalizedName);
		setCreativeTab(DemoTab.Tab);
    
    }
	
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
    	list.add(TextFormatting.WHITE + "Creates a chest with loot");
    	list.add(TextFormatting.ITALIC + "Normally places our custom loot table");
    	list.add(TextFormatting.ITALIC + "Sneaking places a modified loot table");
    }
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing theface, float hitX, float hitY, float hitZ)
	{
		
		IBlockState iblockstate = Blocks.CHEST.getDefaultState();
		world.setBlockState(pos, Blocks.CHEST.correctFacing(world, pos, iblockstate), 2);
        TileEntity tileentity = world.getTileEntity(pos);
        
        Random random = new Random();

        if (tileentity instanceof TileEntityChest)   
        {
        	/**Our Custom Loot**/
        	ResourceLocation location = ModLootTables.Custom_Chest_Loot;
        	
        	if(player.isSneaking()){
        		/**Our modified Spawn Chest Loot**/
        		location = LootTableList.CHESTS_SPAWN_BONUS_CHEST;
        	}        	
        	
            ((TileEntityChest)tileentity).setLootTable(location, random.nextLong());
        }
		
		
		return EnumActionResult.SUCCESS;
	}
	
}
