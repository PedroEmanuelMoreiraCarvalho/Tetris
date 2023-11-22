package entities;

import java.awt.Color;
import java.awt.Graphics2D;

public class Block {
	
	private int x, y, size;
	private boolean solid = false;
	
	public Block(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
	
	public void right() {
		x += size;
	}
	
	public void left() {
		x -= size;
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
	public int getSize() {
		return size;
	}
	
	public void solidificate() {
		solid = true;
	}
	
}
