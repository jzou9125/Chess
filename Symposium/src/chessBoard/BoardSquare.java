package chessBoard;

import chessPieces.ChessPiece;

public class BoardSquare {

	ChessPiece piece;
	boolean white;
	
	public BoardSquare(ChessPiece piece, boolean white) {
		this.piece = piece; 
		this.white = white;
	}
	
	public ChessPiece getPiece()
	{
		return piece;
	}

}
