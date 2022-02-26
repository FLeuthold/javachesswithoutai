package schach.pieces;

import schach.Piece;
import schach.Tile;

public class Rook extends Piece{
	public Rook(boolean black) {
		super("Rook", black);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean testPattern(Tile[] board, Tile start, Tile end) {
		
			if(end.x == start.x){
				int minY = Math.min(start.y, end.y);
				int x = end.x; //könnte auch start.x, weil beide gleich in dem Fall
				for(int i = 1; i < minY; i++ ){
					if(board[x + (minY + i)*8].getPiece() != null)
						return false;				
				}
				return true;
			}else if (end.y == start.y) {
				int minX = Math.min(start.x, end.x);
				//Math.signum(minX);
				int y = end.y;
				for(int i = 1; i < minX; i++ ){
					if(board[(minX + i ) + y*8].getPiece() != null)
						return false;
				}
				return true;
			}
			
			return false;

	}

	public boolean between() {
		/*if(model.feldNach.x == model.feldVon.x){
	    for(int i = 1; i < Math.max(model.feldVon.y, model.feldNach.y); i++ ){
		if(model.felder[minCol + i][maxRow - i].figur != null)
		    return true;
	    }
	}
	for(int i = 0; ) {
	    if(figur.zahl == this.zahl ) {		
		boolean isBetweenZahl = (zahl < figur.zahl && figur.zahl < this.zahl) || (zahl > figur.zahl && figur.zahl > this.zahl) ;		
		if(isBetweenZahl) {
		    return false;
		}
	    }	    
	    if(figur.letter == this.letter) {
		boolean isBetweenLetter = (letter < figur.letter && figur.letter < this.letter) || (letter > figur.letter && figur.letter > this.letter);    
		if(isBetweenLetter) {
		    return false;
		}
	    }
	}*/
		return true;
	}
}
