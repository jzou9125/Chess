package chessBoard;

import java.awt.Image;

public class BoardTile {

	ChessPiece piece;
	BoardTile[] pawnMovements = new BoardTile[3];
	BoardTile[] knightMovements = new BoardTile[8];
	BoardTile[] bishopMovements = new BoardTile[13];
	BoardTile[] queenMovements = new BoardTile[27];
	BoardTile[] rookMovements = new BoardTile[14];
	BoardTile[] kingMovements = new BoardTile[8];
	String col;
	int row;
	Image tileImage;
	
	public BoardTile(ChessPiece piece, Image tile, String col, int row) {
		this.piece = piece;
		tileImage = tile;
		this.col = col;
		this.row = row;
	}
	public BoardTile(BoardTile[] pawn, BoardTile[] knight, BoardTile[] bishop, BoardTile[] queen, BoardTile[] rook, BoardTile[] king, Image tile, String col, int row) {
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

}
