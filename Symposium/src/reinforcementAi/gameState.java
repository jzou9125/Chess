package reinforcementAi;

import java.util.ArrayList;

import chessBoard.BoardTile;

public class gameState {
	
	private gameState previous;
	private ArrayList<ArrayList<BoardTile>> legal;
	private ArrayList<gameState> newStates = new ArrayList<gameState>();
	private int winCount = 0;

	public gameState(ArrayList<ArrayList<BoardTile>> legalMoves, gameState previousState) {
		legal = legalMoves;
		previous = previousState;
	}
	
	public gameState(ArrayList<ArrayList< BoardTile>> legalMoves) { //base
		legal = legalMoves;
	}

	public void setPrevious(gameState previous) {
		this.previous = previous;
	}
	
	public gameState getPrevious() {
		return previous;
	}

	public int getWinCount() {
		return winCount;
	}

	public void setWinCount() {
		this.winCount++;
	}

	public ArrayList<gameState> getNewStates() {
		return newStates;
	}

}
