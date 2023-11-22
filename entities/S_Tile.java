package entities;

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
	}
}
