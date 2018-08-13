package chessBoard;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;

public class ChessBoard {

	private BoardTile[][] board = new BoardTile[8][8];
	private String[] chessString = {"Rook", "Bishop", "Knight", "Queen", "King", "Knight", "Bishop", "Rook"};
	private ImageIcon[] tileImage = {new ImageIcon("Images/White Tile.png"), new ImageIcon("Images/Black Tile.png")};
	private ChessPiece[] wPieces = new ChessPiece[16];
	private ChessPiece[] bPieces = new ChessPiece[16];
	ArrayList<ArrayList<BoardTile>> wVia = new ArrayList<ArrayList<BoardTile>>(); 
	ArrayList<ArrayList<BoardTile>> bVia = new ArrayList<ArrayList<BoardTile>>(); 
	public ChessBoard() {
		/*try {
			FileInputStream fileIn = new FileInputStream("Data/Board.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			board = (BoardTile[][]) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Board not found");
			c.printStackTrace();
			return;*/
		createBoard();
	}

	private void createBoard() {
		int i = 0;
		for(int row =0; row<8; row++) {
			for(int col = 0; col<8; col++) {
				board[row][col] = new BoardTile(null, tileImage[row+i%2],col, row);
			}
			i++;
		}
		createPieces("W" , wPieces);
		createPieces("B", bPieces);
		placePieces(0, wPieces);
		placePieces(7, bPieces);
		generateAllPossibleMoves();
	}

	private void generateAllPossibleMoves() {
		
	}
	
	private ArrayList<BoardTile> left(BoardTile current) {
		return new ArrayList<BoardTile>(Arrays.asList(Arrays.copyOfRange(board[current.getRow()], 0, current.getCol())));
	}
	private ArrayList<BoardTile> right(BoardTile current) {
		return new ArrayList<BoardTile>(Arrays.asList(Arrays.copyOfRange(board[current.getRow()], current.getCol(), board[current.getRow()].length)));
	}
	private ArrayList<BoardTile> top(BoardTile current) {
		ArrayList<BoardTile> top = new ArrayList<BoardTile>();
		for(int i = 0; i<current.getRow(); i++) {
			top.add(board[i][current.getCol()]);
		}
		return top;
	}
	private ArrayList<BoardTile> bottom(BoardTile current) {
		ArrayList<BoardTile> bottom = new ArrayList<BoardTile>();
		for(int i = current.getRow(); i<board.length; i++) {
			bottom.add(board[i][current.getCol()]);
		}
		return bottom;
	}
	private ArrayList<BoardTile> ne(BoardTile) {
		
	}

	private void placePieces(int rowStart, ChessPiece[] chessP) {
		for(int i = 0; i<8; i++) {
			board[rowStart][i].setChessPiece(chessP[i+8]);
			if(rowStart == 0)
				board[rowStart+1][i].setChessPiece(chessP[i]);
			else
				board[rowStart-1][i].setChessPiece(chessP[i]);
		}
	}

	private void createPieces(String prefix, ChessPiece[] chessArray) {
		int i = 0;
		while(i<8) {
			chessArray[i] = new ChessPiece(prefix+"Pawn", new ImageIcon("Images/"+prefix+"Pawn.png"));
			i++;
		}
		for(int a = 0; a+i<wPieces.length; i++) {
			chessArray[i+a] = new ChessPiece(prefix+chessString[a], new ImageIcon("Images/"+chessString[a]+".png"));
			i++;
		}
	}

	
	/*Your king has been moved earlier in the game.
	The rook that castles has been moved earlier in the game.
	There are pieces standing between your king and rook.
	The king is in check.
	The king moves through a square that is attacked by a piece of the opponent.
	The king would be in check after castling.*/


	/*	public boolean castle(ChessPiece currentKing) {
		if(checked(currentKing)) {
			return false;
		}
		if()
		return true;
	}*/

	private void saveChessTiles() {
		try {
			FileOutputStream fileOut = new FileOutputStream("Data/Board.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(board);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in Board.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public void move(ChessPiece piece, BoardTile target, BoardTile previous){
		target.setChessPiece(piece);
		previous.setChessPiece(null);
	}

	public BoardTile[][] getBoard(){
		return board;
	}

	public ArrayList<ArrayList<BoardTile>> getwVia() {
		return wVia;
	}

	public ArrayList<ArrayList<BoardTile>> getbVia() {
		return bVia;
	}
}