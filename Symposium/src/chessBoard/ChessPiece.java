package chessBoard;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class ChessPiece implements Serializable{

	private String pieceType;
	private ImageIcon pieceImage;
	private BoardTile currentTile;
	private boolean hasMoved = false;

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
	public BoardTile getCurrentTile() {
		return currentTile;
	}
	public void setCurrentTile(BoardTile currentTile) {
		this.currentTile = currentTile;
	}
	public boolean isHasMoved() {
		return hasMoved;
	}
	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
}
