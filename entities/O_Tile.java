package entities;

import java.awt.Color;

public class O_Tile extends Tile{
	
	public O_Tile(int x, int y, int size) {
		super(x, y, size);
		Block[] blocks = {
           new Block(x ,y , size),
           new Block(x + size ,y ,size),
           new Block(x , y + size ,size),
           new Block(x + size , y + size ,size)
		}; 
		setBlocks(blocks);
		for(int i = 0; i < blocks.length; i++) blocks[i].setColor(new Color(1f,1f,0f,.5f ));
	}
}
