package chessBoard;

public class Action {

	private String currentPiece;
	private String oppPiece;
	private String Location;
	private String fullMessage;
	
	public Action(ChessPiece Piece, BoardTile move) {
		currentPiece = Piece.getPieceType();
		if(move.getPiece() != null ) {
			oppPiece = move.getPiece().getPieceType();
		}
		Location = move.getCol() + Integer.toString(move.getRow());
		if(oppPiece != null) {
			fullMessage = currentPiece + "killed " + oppPiece + " on " + Location;
		} else {
			fullMessage = currentPiece + "moved to " + Location;  
		}
	}

}
