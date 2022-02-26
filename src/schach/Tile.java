package schach;

import java.awt.Color;

import javax.swing.JButton;

public class Tile extends JButton{
	public final int x, y;
	public boolean possible;
	private Piece piece;

	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
		if ((x + y) % 2 == 0) {
			setBackground(Color.white);
		} else {
			setBackground(Color.black);
		}



	}
	
	public void setPiece(Piece piece) {
		
		
		if(piece != null) {
			this.piece = piece;

			setIcon(piece.image);
		}else {
			this.piece = null;
			setIcon(null);
		}
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	


	/**
	 * posClick wird gespeichert in posStored.
	 */

}
