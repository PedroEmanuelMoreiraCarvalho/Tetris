package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Canvas {
	private final int block_size = 30;
	private int x,y, w = 7, h = 13;
	
	private ArrayList<Tile> tiles = new ArrayList<Tile>();
	
	public Canvas(int x, int y) {
		this.x = x;
		this.y = y;
		tiles.add(new Z_Tile(x,y,block_size));
		tiles.add(new S_Tile(x+2*block_size,y,block_size));
	}
	
	public void tick() {
		for(Tile t:  tiles) {
			t.drown(h * block_size + block_size);
		}
	}
	
	public void render(Graphics2D g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(x, y, w*block_size, h*block_size);
		
		for(Tile t:  tiles) {
			t.render(g);
		}
	}
}
