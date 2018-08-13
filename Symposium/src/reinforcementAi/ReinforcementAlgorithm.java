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
	ArrayList<gameState> wGameHistory = new ArrayList<gameState>();
	ArrayList<gameState> bGameHistory = new ArrayList<gameState>();
	private Starter hub;
	
	public ReinforcementAlgorithm(Starter hub) {
		networkB = new Neuron[64][129]; //+2 for castle
		networkW = new Neuron[64][129];
		createNeuralN(networkB);
		createNeuralN(networkW);
		this.hub = hub;
		
		wGameHistory.add(new gameState(hub.getBoard().getwVia()));
		bGameHistory.add(new gameState(hub.getBoard().getbVia()));
	}
	
	public void connectNeuralN(Neuron[][] arr) {
		for(int i = 0; i< arr.length -1; i++) {
			for(int j = 0; j<arr[i].length; j++) {
				arr[i][j].setOutput(arr[i+1]);
			}
		}
	}
	public void createNeuralN(Neuron[][] arr) {
		for(int row =0; row < arr.length-1; row++) {
			for(int col = 0; col< arr[row].length; col++) {
				arr[row][col] = new Neuron(null);
			}
		}
		for(int i = 0; i< 16; i++ ) {
			arr[arr.length-1][i] = new Neuron(null);
		}
		connectNeuralN(arr);
	}
	
	/*Monte Carlo Tree Search backpropagation
	find the most promising tree to have the ai often use*/
	
	public void trainingMethod() {
		//move random piece
		//check if the position is in a good place
		
	}
	
	public void inputData(double[] value, Neuron[][] neuralNet) 
	{
		for(int i = 0; i<neuralNet.length; i++) {
			neuralNet[0][i].addInputs(value[i]);
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
