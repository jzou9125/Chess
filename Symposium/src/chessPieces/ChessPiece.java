package chessPieces;

import java.util.ArrayList;

import chessBoard.BoardSquare;

public interface ChessPiece {

	ArrayList<BoardSquare> aviableMoves = new ArrayList<BoardSquare>();
	
	public void editAviableMoves();
}
