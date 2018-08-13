package chessBoard;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class ChessPiece implements Serializable{

	private String pieceType;
	private ImageIcon pieceImage;
	private boolean hasMoved = false;

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
	public boolean isHasMoved() {
		return hasMoved;
	}
	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
}
