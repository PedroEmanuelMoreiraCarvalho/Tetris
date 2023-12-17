package entities;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Tile {
	
	protected int x, y, size, rotations = 0;
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
	
	protected boolean collideWith(int min, int max, int maxH, ArrayList<Block> solid_blocks) {
		for(int i = 0; i < blocks.length; i++){
			if(	blocks[i].getX() > max ||
				blocks[i].getX() < min ||
				blocks[i].getY() > maxH
			) return true;
			
			for(Block solid: solid_blocks) {
				if(
					blocks[i].getY() >= solid.getY() &&
					blocks[i].getY() < solid.getY() + size &&
					blocks[i].getX() >= solid.getX() &&
					blocks[i].getX() < solid.getX() + size 
				) return true;
				
			}
		}
		return false;
	}
	
	public void right(int max, ArrayList<Block> solid_blocks) {
		for(int i = 0; i < blocks.length; i++) {
			Block b = blocks[i];
			if(b.getX() + size > max) return;
		}
		
		for(Block solid: solid_blocks) {
			for(int i = 0; i < blocks.length; i++){	
				if(blocks[i].getY() >= solid.getY() &&
					blocks[i].getY() < solid.getY() + size &&
					blocks[i].getX() + size >= solid.getX() &&
					blocks[i].getX() + size < solid.getX() + solid.getSize()
				) return;
			}
		}
		
		for(int i = 0; i < blocks.length; i++) {
			blocks[i].right();
		}
		x += size;
	}
	
	public void left(int min, ArrayList<Block> solid_blocks) {
		for(int i = 0; i < blocks.length; i++)
			if( blocks[i].getX() - size < min) return;

		for(Block solid: solid_blocks) {
			for(int i = 0; i < blocks.length; i++){	
				if(blocks[i].getY() >= solid.getY() &&
					blocks[i].getY() < solid.getY() + size &&
					blocks[i].getX() - size >= solid.getX() &&
					blocks[i].getX() - size < solid.getX() + solid.getSize()
				) return;
			}
		}
		
		for(int i = 0; i < blocks.length; i++) {
			blocks[i].left();			
		}
		x -= size;
	}
	
	public void drown(int ground, ArrayList<Block> solid_blocks) {
		if(!isFalling) return;
		
		for(Block solid: solid_blocks) {
			for(int i = 0; i < blocks.length; i++){	
				if(blocks[i].getY() + size >= solid.getY() &&
					blocks[i].getY() < solid.getY() + size &&
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
		y += size;
	}
	
	public void rotate(int min, int max, int maxH, ArrayList<Block> solid_blocks) {
		//verification
			Tile pseudoTile = null;

			if(this instanceof L_Tile) pseudoTile = new L_Tile(x,y,size);
			if(this instanceof I_Tile) pseudoTile = new I_Tile(x,y,size);
			if(this instanceof J_Tile) pseudoTile = new J_Tile(x,y,size);
			if(this instanceof O_Tile) pseudoTile = new O_Tile(x,y,size);
			if(this instanceof S_Tile) pseudoTile = new S_Tile(x,y,size);
			if(this instanceof T_Tile) pseudoTile = new T_Tile(x,y,size);
			if(this instanceof Z_Tile) pseudoTile = new Z_Tile(x,y,size);
			
			Block[] new_blocks = {
	           new Block(blocks[0].getX(), blocks[0].getY() , size),
	           new Block(blocks[1].getX(), blocks[1].getY() , size),
	           new Block(blocks[2].getX(), blocks[2].getY() , size),
	           new Block(blocks[3].getX(), blocks[3].getY() , size),
			};
			
			pseudoTile.setBlocks(new_blocks);
			pseudoTile.rotateBlocks(rotations + 1);
			if(pseudoTile.collideWith(min, max, maxH, solid_blocks)) return;
		//
			
		blocks[0].setCoord(pseudoTile.getBlocks()[0].getX(), pseudoTile.getBlocks()[0].getY());		
		blocks[1].setCoord(pseudoTile.getBlocks()[1].getX(), pseudoTile.getBlocks()[1].getY());		
		blocks[2].setCoord(pseudoTile.getBlocks()[2].getX(), pseudoTile.getBlocks()[2].getY());		
		blocks[3].setCoord(pseudoTile.getBlocks()[3].getX(), pseudoTile.getBlocks()[3].getY());
		
		rotations++;
		if(rotations == 4) rotations = 0;
	}
	
	protected void rotateBlocks(int rotations) {}
	
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
