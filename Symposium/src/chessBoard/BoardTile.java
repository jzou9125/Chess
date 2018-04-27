package chessBoard;

import java.awt.Image;

import javax.swing.ImageIcon;

public class BoardTile {

	private ChessPiece piece;
	private String [][] pawnMovements = new String[3][2];
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
	public BoardTile(String[][] pawn, String[][] knight, String[][] bishop, String[][] queen, String[][] rook, String[][] king, ImageIcon tile, String col, int row) {
		pawnMovements = pawn;
		knightMovements = knight;
		bishopMovements = bishop;
		queenMovements = queen;
		rookMovements = rook;
		kingMovements = king;
		
		tileImage = tile;
		this.row = row;
		this.col = col;
	}
	
	public ChessPiece getPiece()
	{
		return piece;
	}
	
	public void setChessPiece(ChessPiece piece)
	{
		this.piece = piece; 
	}
	public void setPawnMovements(String[][] pawnMovements) {
		this.pawnMovements = pawnMovements;
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
	public String[][] getPawnMovements() {
		return pawnMovements;
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
