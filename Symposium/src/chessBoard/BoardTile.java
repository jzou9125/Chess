package chessBoard;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class BoardTile implements Serializable {

	private ChessPiece piece;
	private int col;
	private int row;
	private ImageIcon tileImage;
	private ArrayList<BoardTile> rookMovement = new ArrayList<BoardTile>();
	private ArrayList<BoardTile> bishopMovement = new ArrayList<BoardTile>();
	private ArrayList<BoardTile> knightMovement = new ArrayList<BoardTile>();
	private ArrayList<BoardTile> wPawnMovement = new ArrayList<BoardTile>();
	private ArrayList<BoardTile> bPawnMovement = new ArrayList<BoardTile>();
	private ArrayList<BoardTile> queenMovement = new ArrayList<BoardTile>();
	private ArrayList<BoardTile> kingMovement = new ArrayList<BoardTile>();
	

	public BoardTile(ChessPiece piece, ImageIcon tile, int col, int row) {
		this.piece = piece;
		tileImage = tile;
		this.col = col;
		this.row = row;
	}
	public ChessPiece getPiece() {
		return piece;
	}
	
	public void setChessPiece(ChessPiece piece) {
		this.piece = piece; 
	}
	public int getCol() {
		return col;
	}
	public int getRow() {
		return row;
	}
	public ImageIcon getTileImage() {
		return tileImage;
	}

}
