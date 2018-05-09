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
	
	public ChessBoard getBoard()
	{
		return board;
	}

	//two neural networks? (one for actions the other for victory
	
	
	/*
	 * 
	 * Insert inputs to neural network and then have the neural network output a value
	 * 
	 */
	public void inputData()
	{
		
	}
	
}
