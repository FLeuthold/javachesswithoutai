package schach.pieces;

import schach.Board;
import schach.Piece;
import schach.Tile;

public class King extends Piece{

    public King(Board board, boolean black) {
	super("Koenig", black);
	// TODO Auto-generated constructor stub
    }

    @Override
    public boolean testPattern(Tile[] board, Tile start, Tile end) {
	// TODO Auto-generated method stub
    	return false;
    }

}
