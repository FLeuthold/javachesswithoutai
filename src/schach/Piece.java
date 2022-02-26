package schach;

import javax.swing.ImageIcon;

public abstract class Piece {
	public final ImageIcon image;
	public final boolean black;

	public Piece(String iconPath, boolean black) {
		if(black){
			image = new ImageIcon(Piece.class.getResource("/pieces/"+ iconPath + "Black.jpg"));
		}else{
			image = new ImageIcon(Piece.class.getResource("/pieces/"+ iconPath + ".jpg"));
		}
		this.black = black;
	}

	public abstract boolean testPattern(Tile[] board, Tile start, Tile end);

}
