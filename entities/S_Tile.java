package entities;

import java.awt.Color;

public class S_Tile extends Tile{
	
	public S_Tile(int x, int y, int size) {
		super(x, y, size);
		Block[] blocks = {
           new Block(x + size,y , size),
           new Block(x + 2 * size ,y ,size),
           new Block(x , y + size ,size),
           new Block(x + size , y + size ,size)
		}; 
		setBlocks(blocks);
		for(int i = 0; i < blocks.length; i++) blocks[i].setColor(Color.green);
	}
	
	@Override
	protected void rotateBlocks(int rotations){
		switch(rotations) {
		case 1:
			blocks[0] .setCoord(blocks[0].getX() - size , blocks[0].getY() - size);
			blocks[1].setCoord(blocks[1].getX() - 2 * size , blocks[1].getY()); // + size  - size);
			blocks[2] .setCoord(blocks[2].getX() + size, blocks[2].getY()  - size);
			blocks[3] .setCoord(blocks[3].getX(), blocks[3].getY());
			break;
		}
	}
}
