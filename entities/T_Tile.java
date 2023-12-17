package entities;

import java.awt.Color;

public class T_Tile extends Tile{
	
	public T_Tile(int x, int y, int size) {
		super(x, y, size);
		Block[] blocks = {
           new Block(x + size ,y , size),
           new Block(x ,y + size ,size),
           new Block(x + size , y + size ,size),
           new Block(x + 2 * size , y + size ,size)
		}; 
		setBlocks(blocks);
		for(int i = 0; i < blocks.length; i++) blocks[i].setColor(new Color(0f,0f,1f,.5f ));
	}
	
	@Override
	protected void rotateBlocks(int rotations){
		switch(rotations) {
		case 1:
			blocks[0].setCoord(blocks[0].getX() - size, blocks[0].getY());
			blocks[1].setCoord(blocks[1].getX(), blocks[1].getY());
			blocks[2].setCoord(blocks[2].getX(), blocks[2].getY());
			blocks[3].setCoord(blocks[3].getX() - 2 * size, blocks[3].getY() + size);
			break;
		case 2:
			blocks[0].setCoord(blocks[0].getX(), blocks[0].getY());
			blocks[1].setCoord(blocks[1].getX() + size, blocks[1].getY() - size);
			blocks[2].setCoord(blocks[2].getX() + size, blocks[2].getY() - size);
			blocks[3].setCoord(blocks[3].getX() + size, blocks[3].getY() - size);
			break;
		case 3:
			blocks[0].setCoord(blocks[0].getX() + size, blocks[0].getY());
			blocks[1].setCoord(blocks[1].getX() - size, blocks[1].getY() + size);
			blocks[2].setCoord(blocks[2].getX() - size, blocks[2].getY() + size);
			blocks[3].setCoord(blocks[3].getX(), blocks[3].getY() + size);
			break;
		case 4:
			blocks[3].setCoord(blocks[3].getX() + size, blocks[3].getY() - size);
			break;
		default:
			break;
		}
	}
}
