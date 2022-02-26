package schach.pieces;

import schach.Piece;
import schach.Tile;

public class Bishop extends Piece{

	public Bishop(boolean black) {
		super("Bishop", black);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean testPattern(Tile[] board, Tile start, Tile end) {

		int diffY = start.y - end.y;
		int diffX = start.x - end.x;
		int minX = Math.min(start.x, end.x);

		if(diffY == -diffX ) {			
			int maxY = Math.max(start.y, end.y);
			int absY = Math.abs(diffY);
			for(int i = 1; i < absY; i++) {
				if(board[(minX + i) + (maxY - i)*8] != null)
					return false;				
			}
			return true;
		} else if (diffY == diffX) {
			int minY = Math.min(start.y, end.y) ;
			for(int i = 1; i < Math.abs(diffY); i++) {
				if(board[(minX + i) + (minY + i)*8]  != null)
					return false;		
			}
			return true;
		}	
		return false;
	}
}
