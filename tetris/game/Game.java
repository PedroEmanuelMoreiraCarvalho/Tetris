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
	
	private int WIDTH = 350, HEIGHT = 700, timer = 30; //simer_set = 40
	private static final long serialVersionUID = 1L;
	public static JFrame frame = new JFrame("Tetris");
	private boolean speed_game = false;

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
		int time_speed;
		if(speed_game) {
			time_speed = timer / 4;
		}else {
			time_speed = timer;
		}
		canvas.tick(time_speed);
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
	
	public void increaseSpeed() {
		speed_game = true; 
	}
	
	public void decreaseSpeed() {
		speed_game = false; 
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
			canvas.getUnsolidTile().left(canvas.getX(), canvas.getSolidBlocks());
		}else if(key == KeyEvent.VK_DOWN) {
			increaseSpeed();
		}else if(key == KeyEvent.VK_SPACE) {
			canvas.setRotate(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_DOWN) {
			decreaseSpeed();
		}
	}
}


//by Ierokirykas