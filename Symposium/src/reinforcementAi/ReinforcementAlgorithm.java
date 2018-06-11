package reinforcementAi;

import java.io.Serializable;
import java.util.ArrayList;

import chessBoard.Action;
import chessBoard.BoardTile;
import chessBoard.ChessBoard;
import game.Starter;

public class ReinforcementAlgorithm implements Serializable{

	private Neuron[][] network = new Neuron[20][64];
	private ArrayList<Action> mov = new ArrayList<Action>();
	
	public ReinforcementAlgorithm() {
		
	}
	
	
	/*Monte Carlo Tree Search backpropagation
	find the most promising tree to have the ai often use*/
	
	public void trainingMethod() {
		//move random piece
		//check if the position is in a good place
		
	}
	
	
	//if anything becomes useless
	//  probably unnecessary
	public void pruningConnections() {
		
	}
	
	/*
	 * Takes all legal moves
	 * Takes considers the state?
	 * 
	 */
	public void inputData(ArrayList<ArrayList<BoardTile>> via)
	{
		
	}
	
	// save after determined time or number of games
	public void saveNN()
	{
		
	}
	

	public void loadNN()
	{
		
	}
	
}
