package entities;

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
	}
}
