package entities;

import java.awt.Color;

public class I_Tile extends Tile{
	
	public I_Tile(int x, int y, int size) {
		super(x, y, size);
		Block[] blocks = {
           new Block(x ,y , size),
           new Block(x + size ,y ,size),
           new Block(x + 2 * size ,y ,size),
           new Block(x + 3 * size ,y ,size)
		}; 
		setBlocks(blocks);
		for(int i = 0; i < blocks.length; i++) blocks[i].setColor(new Color(0f,1f,1f,.5f ));
	}
	
	@Override
	protected void rotateBlocks(int rotations){
		switch(rotations % 2) {
		case 1:
			blocks[0].setCoord(blocks[0].getX() +  size, blocks[0].getY());
			blocks[1].setCoord(blocks[1].getX(), blocks[1].getY() + size);
			blocks[2].setCoord(blocks[2].getX() - 1 * size , blocks[2].getY() + 2 * size);
			blocks[3].setCoord(blocks[3].getX() - 2 * size , blocks[3].getY() + 3 * size);
			break;
		case 0:
			blocks[0].setCoord(blocks[0].getX() -  size, blocks[0].getY());
			blocks[1].setCoord(blocks[1].getX(), blocks[1].getY() - size);
			blocks[2].setCoord(blocks[2].getX() + 1 * size , blocks[2].getY() - 2 * size);
			blocks[3].setCoord(blocks[3].getX() + 2 * size , blocks[3].getY() - 3 * size);
			break;
		default:
			break;
		}
	}
}
