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
		game.start();
		

	}

	private void start() {
		// TODO Auto-generated method stub
		
	}
	
	public ChessBoard getBoard()
	{
		return board;
	}


}
