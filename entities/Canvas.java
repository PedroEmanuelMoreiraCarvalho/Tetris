package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Canvas {
	private final int block_size = 30;
	private int x,y, w = 8, h = 15, timer = 0;
	
	private ArrayList<Tile> tiles = new ArrayList<Tile>();
	private ArrayList<Block> solid_blocks = new ArrayList<Block>();
	private Tile unsolid_tile;
	
	private int next_block = 1;
	
	public Canvas(int x, int y) {
		this.x = x;
		this.y = y;
		unsolid_tile = new Z_Tile(x,y,block_size);
		tiles.add(unsolid_tile);
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
			return new J_Tile(x,y,block_size);
		case 4:
			return new L_Tile(x,y,block_size);
		case 5:
			return new S_Tile(x,y,block_size);
		case 6:
			return new Z_Tile(x,y,block_size);
		case 7:
			return new T_Tile(x,y,block_size);
		default:
			return new T_Tile(x,y,block_size);
		}
	}
	
	public void tick(int max_timer) {
		timer++;
		
		if(timer > max_timer) {
			for(Tile t:  tiles) {
				t.drown(h * block_size + block_size, solid_blocks);
				if(!t.isFalling()) t.solidificate();
			}
			timer = 0;
		}
		
		if(unsolid_tile.isSolid()) {
			
			for(int i = 0; i < unsolid_tile.getBlocks().length; i++) {
				solid_blocks.add(unsolid_tile.getBlocks()[i]);
			}
			
			unsolid_tile = NewBlock();
			tiles.add(unsolid_tile);
		}
	}
	
	public void render(Graphics2D g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(x, y, w*block_size, h*block_size);
		
		for(Tile t:  tiles) {
			t.render(g);
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
}
