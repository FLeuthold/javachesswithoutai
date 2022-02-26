package schach.pieces;

import schach.Board;
import schach.Piece;
import schach.Tile;

public class Queen extends Piece{
    public Bishop bishop;
    public Rook rook;
    
    public Queen(Board board, boolean black) {
	super("Dame", black);
	
	bishop = new Bishop( black);
	rook = new Rook( black);
    }

    @Override
    public boolean testPattern(Tile[] board, Tile start, Tile end) {
    	return rook.testPattern(board, start, end) || bishop.testPattern(board, start, end);
    }

}
