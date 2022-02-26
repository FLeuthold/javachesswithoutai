package schach.pieces;

import schach.Board;
import schach.Piece;
import schach.Tile;

public class Pawn extends Piece{
	boolean firstMove;

	public Pawn(Board board, boolean black) {
		super("Pawn", black);
		// TODO Auto-generated constructor stub

		firstMove = true;
	}

	@Override
	public boolean testPattern(Tile[] board, Tile start, Tile end) {
		int diffZahl = start.y - end.y ;	
		int diffLetter = start.x - end.x;

		boolean einsOderZwei = diffLetter == 0 && (diffZahl == 1 || (firstMove && diffZahl == 2));
		boolean isBeatPossible = end != null && diffZahl == 1 && (diffLetter == 1 || diffLetter == -1);

		if(einsOderZwei || isBeatPossible ) {
			firstMove = false;
			return true;
		}

		return false;
	}

}
