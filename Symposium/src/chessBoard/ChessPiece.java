package chessBoard;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class ChessPiece implements Serializable{

	String pieceType;
	ImageIcon pieceImage;
	BoardTile currentTile;
	public ChessPiece( String desc, ImageIcon image, BoardTile tile) {
		pieceType = desc;
		pieceImage = image;
		currentTile = tile;
	}
	public String getPieceType() {
		return pieceType;
	}
	public ImageIcon getPieceImage() {
		return pieceImage;
	}

}
