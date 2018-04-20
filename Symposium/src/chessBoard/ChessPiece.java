package chessBoard;

import javax.swing.ImageIcon;

public class ChessPiece {

	String pieceType;
	ImageIcon pieceImage;
	public ChessPiece( String desc, ImageIcon image) {
		pieceType = desc;
		pieceImage = image;
		
	}
	public String getPieceType() {
		return pieceType;
	}
	public ImageIcon getPieceImage() {
		return pieceImage;
	}

}
