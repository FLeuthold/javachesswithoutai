package schach;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

import schach.pieces.*;


public class Board extends JFrame{
	public ArrayList<Piece> pieces;
	public Tile tstored;   
	public int moveCount;
	public Tile[] tiles;
	public JPanel contentPane;

	public static void main(String[] args) {


		Board board = new Board();
		board.setVisible(true);
	}

	public Board() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(8, 8));


		tiles = new Tile[8*8];
		pieces = new ArrayList<Piece>();



		ActionListener tileClick = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Tile tstart = tstored;
				Tile tend = (Tile)e.getSource();
				if(tstart != null) {


					if (tstart.getPiece() != null) {

						/**
						 * It's [color]'s turn and [color] is chosen. Furthermore, the target piece is
						 * null or has the oponent's color
						 */
						if ((
								(
										(!tstart.getPiece().black && (moveCount % 2 == 0))
										&&  (tend.getPiece() == null || tend.getPiece().black)
										) 
								||(
										(tstart.getPiece().black && (moveCount % 2 == 1)) 
										&&  (tend.getPiece() == null || !tend.getPiece().black)
										)
								)
								&& tstart.getPiece().testPattern(tiles, tstart, tend)
								) {

							tend.setPiece(tstart.getPiece()); //setter for view
							tstart.setPiece(null);
							moveCount++;


						}

						

					}
				}
				tstored = tend;
			}
		};

		for (int y = 0; y < 8; ++y) {
			for (int x = 0; x < 8; ++x) {
				tiles[x+y*8] = new Tile( x, y);
				tiles[x+y*8].addActionListener(tileClick);
				contentPane.add(tiles[x+y*8]);
			}
		}

		Queen queenWhite = new Queen(this, false);	
		pieces.add(queenWhite);	
		tiles[3+7*8].setPiece(queenWhite);

		Queen queenBlack = new Queen(this, true);	
		pieces.add(queenBlack);
		tiles[3+0*8].setPiece(queenBlack);

		Pawn pawnWhite1 = new Pawn(this, false);// schwarze Bauern noch nicht implementiert	
		pieces.add(pawnWhite1);
		tiles[3+6*8].setPiece(pawnWhite1);

		Pawn pawnWhite2 = new Pawn(this, false);	
		pieces.add(pawnWhite2);
		tiles[4+6*8].setPiece(  pawnWhite2);

	}

}
