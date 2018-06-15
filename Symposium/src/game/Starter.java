package game;

import chessBoard.BoardTile;
import chessBoard.ChessBoard;
import chessBoard.ChessPiece;
import chessGUI.GUI;

public class Starter {

	private	ChessBoard board;
	private GUI fGame;
	
	public Starter() {
		board = new ChessBoard();
		fGame = new GUI(board);
	}

	public static void main(String[] args) {
		Starter game = new Starter();
		//ai start + determine environment
	}
	
	
	public boolean actionPosible(String side)
	{
		return false;
	}
	
	//https://stackoverflow.com/questions/6236119/how-to-develop-screen-capture-to-video-application
	public void saveGame()
	{
		
	}
	
	public ChessBoard getBoard()
	{
		return board;
	}

}
