package chessBoard;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class BoardTile implements Serializable {

	private ChessPiece piece;
	private String[][] bPawnMovements = new String[3][2];
	private String[][] wPawnMovements = new String[3][2];
	private String[][] knightMovements = new String[8][2];
	private String[][] bishopMovements = new String[13][2];
	private String[][] queenMovements = new String[27][2];
	private String[][] rookMovements = new String[14][2];
	private String[][] kingMovements = new String[8][2];
	private String col;
	private int row;
	private ImageIcon tileImage;

	public BoardTile(ChessPiece piece, ImageIcon tile, String col, int row) {
		this.piece = piece;
		tileImage = tile;
		this.col = col;
		this.row = row;
	}

	public ChessPiece getPiece() {
		return piece;
	}

	public String[][] getmov(String s) {
		if(s.equals("WPawn")) {
			return getwPawnMovements();
		}
		if(s.equals("BPawn")) {
			return getbPawnMovements();
		}
		if(s.equals("Bishop")) {
			return getBishopMovements();
		}
		if(s.equals("Queen")) {
			return getQueenMovements();
		}
		if(s.equals("King")) {
			return getKingMovements();
		}
		if(s.equals("Rook")) {
			return getRookMovements();
		}
		if(s.equals("Knight")) {
			return getKnightMovements();
		}
		return null;
	}
	
	public void setChessPiece(ChessPiece piece) {
		this.piece = piece; 
	}
	public void setKnightMovements(String[][] knightMovements) {
		this.knightMovements = knightMovements;
	}
	public void setBishopMovements(String[][] bishopMovements) {
		this.bishopMovements = bishopMovements;
	}
	public void setQueenMovements(String[][] queenMovements) {
		this.queenMovements = queenMovements;
	}
	public void setRookMovements(String[][] rookMovements) {
		this.rookMovements = rookMovements;
	}
	public void setKingMovements(String[][] kingMovements) {
		this.kingMovements = kingMovements;
	}
	public String[][] getbPawnMovements() {
		return bPawnMovements;
	}
	public void setbPawnMovements(String[][] bPawnMovements) {
		this.bPawnMovements = bPawnMovements;
	}
	public String[][] getwPawnMovements() {
		return wPawnMovements;
	}
	public void setwPawnMovements(String[][] wPawnMovements) {
		this.wPawnMovements = wPawnMovements;
	}
	public String[][] getKnightMovements() {
		return knightMovements;
	}
	public String[][] getBishopMovements() {
		return bishopMovements;
	}
	public String[][] getQueenMovements() {
		return queenMovements;
	}
	public String[][] getRookMovements() {
		return rookMovements;
	}
	public String[][] getKingMovements() {
		return kingMovements;
	}
	public String getCol() {
		return col;
	}
	public int getRow() {
		return row;
	}
	public ImageIcon getTileImage() {
		return tileImage;
	}

}
