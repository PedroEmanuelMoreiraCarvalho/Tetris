package tetris.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entities.Canvas;

public class Game extends JPanel{
	
	private int WIDTH = 300, HEIGHT = 500, timer = 800;
	private static final long serialVersionUID = 1L;
	public static JFrame frame = new JFrame("Tetris");

	Canvas canvas = new Canvas(20,50);

	public static void main(String[] args) {
		Game game = new Game();
		
		frame.setSize(game.getWidth(), game.getHeight());
		
		frame.add(game);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GameLoop(game);
	}
	
	public void tick() {
		canvas.tick();
	}
	
	public void paint(Graphics g) {
	    super.paintComponents(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.gray);
		g2d.fillRect(0,0, WIDTH, HEIGHT);
		canvas.render(g2d);
	}
	
	public static void GameLoop(Game game) {
		try {
			synchronized (game) {					
				while(true) {
					game.tick();
					game.repaint();
					game.wait(game.getTimer());
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}
}
