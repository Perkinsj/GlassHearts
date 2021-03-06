package com.elytradev.glasshearts;

import java.util.Locale;

import com.google.common.base.Enums;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.INBTSerializable;

public class GlassHeartData implements INBTSerializable<NBTTagCompound> {
	
	private GlassHeartWorldData parent;
	
	private BlockPos pos;
	private EnumGlassColor color;
	private EnumGem gem;
	private int lifeforce;
	
	
	public GlassHeartData(GlassHeartWorldData parent) {
		this.parent = parent;
	}
	
	public GlassHeartData(GlassHeartWorldData parent, BlockPos pos, EnumGlassColor color, EnumGem gem, int lifeforce) {
		this.parent = parent;
		this.pos = pos;
		this.color = color;
		this.gem = gem;
		this.lifeforce = lifeforce;
	}
	
	
	public EnumGlassColor getColor() {
		return color;
	}
	
	public EnumGem getGem() {
		return gem;
	}
	
	public int getLifeforce() {
		return lifeforce;
	}
	
	public BlockPos getPos() {
		return pos;
	}
	
	
	public void setColor(EnumGlassColor color) {
		this.color = color;
		parent.markDirty();
	}
	
	public void setGem(EnumGem gem) {
		this.gem = gem;
		parent.markDirty();
	}
	
	public void setLifeforce(int lifeforce) {
		this.lifeforce = lifeforce;
		parent.markDirty();
	}
	
	public void setPos(BlockPos pos) {
		this.pos = pos;
		parent.markDirty();
	}
	
	@Override
	public void deserializeNBT(NBTTagCompound nbt) {
		pos = BlockPos.fromLong(nbt.getLong("Pos"));
		color = Enums.getIfPresent(EnumGlassColor.class, nbt.getString("Color").toUpperCase(Locale.ROOT)).or(EnumGlassColor.NONE);
		gem = Enums.getIfPresent(EnumGem.class, nbt.getString("Gem").toUpperCase(Locale.ROOT)).or(EnumGem.NONE);
		lifeforce = Math.max(0, Math.min(nbt.getShort("Lifeforce"), 1000));
	}
	
	@Override
	public NBTTagCompound serializeNBT() {
		NBTTagCompound tag = new NBTTagCompound();
		tag.setLong("Pos", pos.toLong());
		tag.setString("Color", color.getName());
		tag.setString("Gem", gem.getName());
		tag.setShort("Lifeforce", (short)lifeforce);
		return tag;
	}
	
}
