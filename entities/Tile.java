package entities;

import java.awt.Graphics2D;

public class Tile {
	
	protected int x, y,size;
	protected Block[] blocks = new Block[4];
	protected boolean isFalling = true;
	
	public Tile(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
	
	protected void setBlocks(Block[] blocks) {
		this.blocks = blocks;
	}
	
	public void drown(int ground) {
		if(!isFalling) return;
		
		for(int i = 0; i < blocks.length; i++) {
			Block b = blocks[i];
			if(b.getY() + size > ground) {
				isFalling = true;
				return;
			}
		}
		
		for(int i = 0; i < blocks.length; i++) {
			Block b = blocks[i];
			b.drown();
		}
	}
	
	public void render(Graphics2D g) {
		for(int i = 0; i < blocks.length; i++) {
			Block b = blocks[i];
			b.render(g);
		}
	}
	
	public boolean isFalling() {
		return isFalling;
	}
}
