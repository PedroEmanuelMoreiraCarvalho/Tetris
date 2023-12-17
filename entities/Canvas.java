package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Canvas {
	private final int block_size = 30;
	private int x,y, w = 10, h = 20, timer = 0;
	
	private ArrayList<Block> solid_blocks = new ArrayList<Block>();
	private Tile unsolid_tile;
	
	private int next_block = 1;
	private boolean rotate = false;
	
	public Canvas(int x, int y) {
		this.x = x;
		this.y = y;
		unsolid_tile = new O_Tile(x,y,block_size);
	}
	
	private Tile NewBlock() {
		int last_block = next_block;
		next_block = (int)(Math.random() * 8);
		if(next_block == last_block) return NewBlock();
		
		switch(next_block) {
		case 1:
			return new I_Tile(x,y,block_size);
		case 2:
			return new O_Tile(x,y,block_size);
		case 3:
			return new L_Tile(x,y,block_size);
		case 4:
			return new J_Tile(x,y,block_size);
		case 5:
			return new S_Tile(x,y,block_size);
		case 6:
			return new Z_Tile(x,y,block_size);
		case 7:
			return new T_Tile(x,y,block_size);
		default:
			return NewBlock();
		}
	}
	
	public void tick(int max_timer) {
		timer++;
		
		if(rotate) {
			unsolid_tile.rotate(getX(),getWidht(),getHeight(), getSolidBlocks());
			rotate = false;
		}
		
		if(timer > max_timer) {
			unsolid_tile.drown(h * block_size + block_size, solid_blocks);
			if(!unsolid_tile.isFalling()) unsolid_tile.solidificate();
			timer = 0;
		}
		
		if(unsolid_tile.isSolid()) {
			
			for(int i = 0; i < unsolid_tile.getBlocks().length; i++) {
				solid_blocks.add(unsolid_tile.getBlocks()[i]);
				checkLines();
			}
			
			unsolid_tile = NewBlock();
		}
	}
	
	public void render(Graphics2D g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(x, y, w*block_size, h*block_size);
		
		unsolid_tile.render(g);
		for(Block block: solid_blocks) {
			block.render(g);
		}
	}
	
	private void checkLines() {		
		for(int i = 0; i < h; i++) {
			ArrayList<Block> blocks_copy = solid_blocks;
			int blocks_in_line = 0;
			int line = (i * block_size + y);
			
			for(int b = 0; b < blocks_copy.size(); b++) {
				Block block = blocks_copy.get(b);
				
				if(block.getY() == line) blocks_in_line++;
			}
			
			if(blocks_in_line == w) {
				for(int j = 0; j < blocks_copy.size(); j++) {
					Block block = blocks_copy.get(j);
					if(block.getY() == line) {
						solid_blocks.remove(block);
						j--;
					}
					if(block.getY() < line) block.drown();
				}
			}
		}		
	}

	public Tile getUnsolidTile() {
		return unsolid_tile;
	}
	
	public ArrayList<Block> getSolidBlocks() {
		return solid_blocks;
	}
	
	public int getWidht() {
		return w * block_size;
	}

	public int getHeight() {
		return h * block_size;
	}
	
	public int getX() {
		return x;
	}

	public void setRotate(boolean b) {
		rotate  = true;
	}

}
