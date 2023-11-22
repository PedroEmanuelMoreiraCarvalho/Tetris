package entities;

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
	}
}
