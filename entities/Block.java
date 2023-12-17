package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Block {
	
	@SuppressWarnings("unused")
	private boolean solid = false;
	private Image tile;
	private int x, y, size;
	private Color color = Color.darkGray;
	
	public Block(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
		try {
			this.tile = ImageIO.read(this.getClass().getResource("/images/mine.png"));
		} catch (IOException e) {
			e.printStackTrace();
		} 
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
		g.drawImage(tile,x,y,size,size,null);
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
