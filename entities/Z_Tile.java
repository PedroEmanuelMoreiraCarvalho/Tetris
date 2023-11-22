package entities;

public class Z_Tile extends Tile{
	
	public Z_Tile(int x, int y, int size) {
		super(x, y, size);
		Block[] blocks = {
           new Block(x ,y , size),
           new Block(x + size ,y ,size),
           new Block(x + size, y + size ,size),
           new Block(x + 2 * size , y + size ,size)
		}; 
		setBlocks(blocks);
	}
}
