package entities;

import java.awt.Color;
import java.awt.Graphics2D;

public class Block {
	
	private int x, y, size;
	
	public Block(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
	
	public void drown() {
		y += size;
	}
	
	public void render(Graphics2D g) {
		g.setColor(Color.darkGray);
		g.fillRect(x, y, size, size);
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
}
