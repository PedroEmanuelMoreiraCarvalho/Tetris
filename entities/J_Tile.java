package entities;

import java.awt.Color;

public class J_Tile extends Tile{

	public J_Tile(int x, int y, int size) {
		super(x, y, size);
		Block[] blocks = {
           new Block(x ,y , size),
           new Block(x ,y + size ,size),
           new Block(x + size , y + size ,size),
           new Block(x + 2 * size , y + size ,size)
		}; 
		setBlocks(blocks);
		for(int i = 0; i < blocks.length; i++) blocks[i].setColor(new Color(1f,0f,1f,.5f ));
	}
	
	@Override
	protected void rotateBlocks(int rotations){
		switch(rotations) {
		case 1:
			blocks[0].setCoord(blocks[0].getX(), blocks[0].getY());
			blocks[1].setCoord(blocks[1].getX() + size, blocks[1].getY() - size);
			blocks[2].setCoord(blocks[2].getX() - size, blocks[2].getY());
			blocks[3].setCoord(blocks[3].getX() - 2 * size, blocks[3].getY() + size);
			break;
		case 2:
			blocks[0].setCoord(blocks[0].getX(), blocks[0].getY());
			blocks[1].setCoord(blocks[1].getX(), blocks[1].getY());
			blocks[2].setCoord(blocks[2].getX() + 2 * size, blocks[2].getY() - size);
			blocks[3].setCoord(blocks[3].getX() + 2 * size, blocks[3].getY() - size);
			break;
		case 3:
			blocks[0].setCoord(blocks[0].getX() + size, blocks[0].getY());
			blocks[1].setCoord(blocks[1].getX(), blocks[1].getY() + size);
			blocks[2].setCoord(blocks[2].getX() - 2 * size, blocks[2].getY() + 2 * size);
			blocks[3].setCoord(blocks[3].getX() - size, blocks[3].getY() + size);
			break;
		case 4:
			blocks[0].setCoord(blocks[0].getX() - size, blocks[0].getY());
			blocks[1].setCoord(blocks[1].getX() - size, blocks[1].getY());
			blocks[2].setCoord(blocks[2].getX() + size, blocks[2].getY() - size);
			blocks[3].setCoord(blocks[3].getX() + size, blocks[3].getY() - size);
			break;
		default:
			break;
		}
	}
	
}
