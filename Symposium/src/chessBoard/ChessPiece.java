package chessBoard;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class ChessPiece implements Serializable{

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
