package game;

import chessBoard.ChessBoard;
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

	}
	
	public ChessBoard getBoard()
	{
		return board;
	}


}
