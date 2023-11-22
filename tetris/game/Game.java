package tetris.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entities.Canvas;

public class Game extends JPanel implements KeyListener{
	
	private int WIDTH = 350, HEIGHT = 600, timer = 10; //simer_set = 40
	private static final long serialVersionUID = 1L;
	public static JFrame frame = new JFrame("Tetris");

	Canvas canvas = new Canvas(20,50);

	public static void main(String[] args) {
		Game game = new Game();
		
		frame.setSize(game.getWidth(), game.getHeight());
		
		frame.add(game);
		frame.addKeyListener(game);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GameLoop(game);
	}
	
	public void tick() {
		canvas.tick(timer);
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
					game.wait(10);
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

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT) {
			canvas.getUnsolidTile().right(canvas.getWidht(), canvas.getSolidBlocks());
		}else if(key == KeyEvent.VK_LEFT) {
			canvas.getUnsolidTile().left(0, canvas.getSolidBlocks());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}


//by Ierokirykas