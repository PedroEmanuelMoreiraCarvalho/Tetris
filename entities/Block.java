package entities;

import java.awt.Color;
import java.awt.Graphics2D;

public class Block {
	
	@SuppressWarnings("unused")
	private boolean solid = false;
	private int x, y, size;
	private Color color = Color.darkGray;
	
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
		g.setColor(getColor());
		g.fillRect(x, y, size, size);
	}
	
	public void setCoord(int x, int y) {
		this.x = x;
		this.y = y;
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
}
