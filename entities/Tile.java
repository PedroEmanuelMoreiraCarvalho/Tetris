package entities;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Tile {
	
	protected int x, y,size;
	protected Block[] blocks = new Block[4];
	protected boolean isFalling = true, isSolid = false;
	
	public Tile(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
	
	protected void setBlocks(Block[] blocks) {
		this.blocks = blocks;
	}
	
	public void right(int max, ArrayList<Block> solid_blocks) {
		for(int i = 0; i < blocks.length; i++) {
			Block b = blocks[i];
			if(b.getX() + size > max) return;
		}
		
		for(Block solid: solid_blocks) {
			for(int i = 0; i < blocks.length; i++){	
				if(blocks[i].getY() >= solid.getY() &&
					blocks[i].getX() + size >= solid.getX() &&
					blocks[i].getX() + size < solid.getX() + solid.getSize()
				) return;
			}
		}
		
		for(int i = 0; i < blocks.length; i++) {
			blocks[i].right();
		}
	}
	
	public void left(int min, ArrayList<Block> solid_blocks) {
		for(int i = 0; i < blocks.length; i++)
			if( blocks[i].getX() - size < min) return;

		for(Block solid: solid_blocks) {
			for(int i = 0; i < blocks.length; i++){	
				if(blocks[i].getY() >= solid.getY() &&
					blocks[i].getX() - size >= solid.getX() &&
					blocks[i].getX() - size < solid.getX() + solid.getSize()
				) return;
			}
		}
		
		for(int i = 0; i < blocks.length; i++) {
			Block b = blocks[i];
			b.left();
		}
	}
	
	public void drown(int ground, ArrayList<Block> solid_blocks) {
		if(!isFalling) return;
		
		for(Block solid: solid_blocks) {
			for(int i = 0; i < blocks.length; i++){	
				if(blocks[i].getY() + size >= solid.getY() &&
					blocks[i].getX() >= solid.getX() &&
					blocks[i].getX() < solid.getX() + solid.getSize()
				) {
					isFalling = false;
					return;
				}
			}
		}
		
		for(int i = 0; i < blocks.length; i++) {
			Block b = blocks[i];
			if(b.getY() + size > ground) {
				isFalling = false;
				return;
			}
		}
		
		for(int i = 0; i < blocks.length; i++) {
			blocks[i].drown();
		}
	}
	
	public void solidificate() {
		for(int i = 0; i < blocks.length; i++) {
			blocks[i].solidificate();
			isSolid = true;
		}
	}
	
	public void render(Graphics2D g) {
		for(int i = 0; i < blocks.length; i++) {
			blocks[i].render(g);
		}
	}
	
	public boolean isFalling() {
		return isFalling;
	}

	public boolean isSolid() {
		return isSolid;
	}
	
	public Block[] getBlocks() {
		return blocks;
	}
}
