package reinforcementAi;

import java.io.Serializable;
import java.util.ArrayList;

import chessBoard.Action;
import chessBoard.BoardTile;
import chessBoard.ChessBoard;
import game.Starter;

public class ReinforcementAlgorithm implements Serializable{

	private Neuron[][] networkB;
	private Neuron[][] networkW;
	private ArrayList<Action> mov = new ArrayList<Action>();
	private Starter hub;
	
	public ReinforcementAlgorithm(Starter hub) {
		networkB = new Neuron[129][64]; //+2 if I finish castle
		networkW = new Neuron[129][64];
		this.hub = hub; 
	}
	
	public void createNeuralN(Neuron[][] arr) {
		for(int row =0; row < arr.length; row++) {
			for(int col = 0; col< arr[row].length; col++) {
				arr[row][col] = new Neuron(null, col);
			}
		}
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
		for(ArrayList<BoardTile> a: via) {
			for(BoardTile e: a) {
				
			}
		}
	}
	
	// save after determined time or number of games
	public void saveNN()
	{
		
	}
	

	public void loadNN()
	{
		
	}
	
}
