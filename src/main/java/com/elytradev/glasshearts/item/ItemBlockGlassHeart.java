package com.elytradev.glasshearts.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockGlassHeart extends ItemBlock {

	public ItemBlockGlassHeart(Block block) {
		super(block);
		setMaxStackSize(1);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "item.glasshearts.glass_heart."+stack.getMetadata();
	}
	
}
