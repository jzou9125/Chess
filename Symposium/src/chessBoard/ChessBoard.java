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
	public static final String[] col = {"A", "B", "C", "D", "E", "F", "G", "H"};


	private String[] chessPieces = {"WRook", "WKnight", "WBishop", "WQueen", "WKing", "WBishop","WKnight","WRook"};
	private String[] chessPiecesB = {"BRook", "BKnight", "BBishop", "BQueen", "BKing", "BBishop","BKnight","BRook"};
	private ImageIcon[] chessImages = {new ImageIcon("Images/Rook.png"), new ImageIcon("Images/Knight.png"), new ImageIcon("Images/Bishop.png")
			, new ImageIcon("Images/Queen.png"), new ImageIcon("Images/King.png"),new ImageIcon("Images/Bishop.png"),
			new ImageIcon("Images/Knight.png"), new ImageIcon("Images/Rook.png")};
	private ImageIcon[] BChessImages = {new ImageIcon("Images/BRook.png"), new ImageIcon("Images/BKnight.png"), new ImageIcon("Images/BBishop.png")
			, new ImageIcon("Images/BQueen.png"), new ImageIcon("Images/BKing.png"),new ImageIcon("Images/BBishop.png"),
			new ImageIcon("Images/BKnight.png"), new ImageIcon("Images/BRook.png")};
	private ImageIcon[] tileFile = {new ImageIcon("Images/White Tile.png"), new ImageIcon("Images/Black Tile.png")};

	private ChessPiece[] wPieces = new ChessPiece[16];
	private ChessPiece[] bPieces = new ChessPiece[16];
	private boolean[] viaWP = new boolean[16];
	private boolean[] viaBP = new boolean[16];
	
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

		int i = 0;
		for(int row =0; row< board.length; row++ ) {
			for( int col = 0; col< board[row].length; col ++)
			{
				if(row%2 == 0) {
					board[row][col] = new BoardTile(null, tileFile[i%2], ChessBoard.col[col], row);
				}
				else {
					board[row][col] = new BoardTile(null, tileFile[(i+1)%2], ChessBoard.col[col], row);
				}
				i++;
			}
		}
		populateBoard();
		giveMov();
		writeChessTiles();
	}
	
	public void valueSystem(BoardTile move) {
		if( move.getPiece() != null) {
			
		}
	}
	
	public void castle() {
		
	}
	
	public boolean checkMate(ChessPiece current) {
		if( current.getPieceType().substring(0, 1).equals("W")) {
			ArrayList<BoardTile> check = bVia.get(12);
			for( ArrayList<BoardTile> l: bVia) {
				for(BoardTile e: l) {
					if(check.indexOf(e) != -1) {
						check.remove(check.indexOf(e));
					}
				}
			}
		} else {
			ArrayList<BoardTile> check = bVia.get(12);
			for( ArrayList<BoardTile> l: bVia) {
				for(BoardTile e: l) {
					if(check.indexOf(e) != -1) {
						check.remove(check.indexOf(e));
					}
				}
			}
		}
		return false;
	}
	
	public void updateVia() {
		wVia =  new ArrayList<ArrayList<BoardTile>>();
		bVia = new ArrayList<ArrayList<BoardTile>>();
		for(int i = 0; i< wPieces.length; i++) {
			if(!wPieces[i].getPieceType().equals("WKing")) {
				if( viableMoves(wPieces[i]).length != 0) {
					wVia.add(new ArrayList<BoardTile>(Arrays.asList(viableMoves(wPieces[i]))));
					viaWP[i] = true;
				}
				
			}
		}
		for(int i = 0; i< bPieces.length; i++) {
			if(!bPieces[i].getPieceType().equals("BKing")) {
				if( viableMoves(bPieces[i]).length != 0) {
					bVia.add(new ArrayList<BoardTile>(Arrays.asList(viableMoves(bPieces[i]))));
					viaBP[i] = true;
				}
				
			}
		}
		wVia.add(new ArrayList<BoardTile>(Arrays.asList(viableMoves(wPieces[12]))));
		bVia.add(new ArrayList<BoardTile>(Arrays.asList(viableMoves(bPieces[12]))));
	}

	public BoardTile[] viableMoves(ChessPiece current){
		BoardTile[] viableInputs = null;
		if(current.getPieceType().equals("WRook") || current.getPieceType().equals("BRook") ) {
			viableInputs = rookVia(current.getCurrentTile().getRookMovements(), current.getCurrentTile().getCol(), current.getCurrentTile().getRow(), current);
		}else {
			if(current.getPieceType().equals("WKnight") || current.getPieceType().equals("BKnight")) {
				viableInputs = knightVia(current.getCurrentTile().getKnightMovements(), current);
			}else {
				if(current.getPieceType().equals("WBishop") || current.getPieceType().equals("BBishop")) {
					viableInputs = bishopVia(current.getCurrentTile().getBishopMovements(), current.getCurrentTile().getCol(), current.getCurrentTile().getRow(), current);
				}else {
					if( current.getPieceType().equals("WQueen") || current.getPieceType().equals("BQueen")) {
						viableInputs = queenVia(current.getCurrentTile().getQueenMovements(),  current.getCurrentTile().getCol(), current.getCurrentTile().getRow(), current);
					}else {
						if( current.getPieceType().equals("WKing") ||  current.getPieceType().equals("BKing")) {
							viableInputs = kingVia(current.getCurrentTile().getKingMovements(), current);
						}else {
							if(current.getPieceType().equals("Pawn")) {
								viableInputs = wPawnVia(current.getCurrentTile().getwPawnMovements(), current);
							}else {
								viableInputs = bPawnVia(current.getCurrentTile().getbPawnMovements(), current);
							}
						}
					}
				}
			}
		}
		return viableInputs;
	}

	private BoardTile[] bPawnVia(String[][] pawnMovements, ChessPiece current) {
		BoardTile[] ans = new BoardTile[pawnMovements.length];
		BoardTile[] arr1 = checkTop(pawnMovements, current.getCurrentTile().getRow(), current);
		BoardTile[] arr2 = checkNorthEast(pawnMovements, current.getCurrentTile().getCol(), current.getCurrentTile().getRow(), current);
		BoardTile[] arr3 = checkNorthWest(pawnMovements, current.getCurrentTile().getCol(), current.getCurrentTile().getRow(), current);
		return append4Arrays(arr1, arr2, arr3, ans);
	}

	private BoardTile[] wPawnVia(String[][] pawnMovements, ChessPiece current) {
		BoardTile[] ans = new BoardTile[pawnMovements.length];
		BoardTile[] arr1 = checkBottom(pawnMovements, current.getCurrentTile().getRow(), current);
		BoardTile[] arr2 = checkSouthEast(pawnMovements, current.getCurrentTile().getCol(), current.getCurrentTile().getRow(), current);
		BoardTile[] arr3 = checkSouthWest(pawnMovements, current.getCurrentTile().getCol(), current.getCurrentTile().getRow(), current);
		return append4Arrays(ans, arr1, arr2, arr3);
	}

	private BoardTile[] kingVia(String[][] kingMovements, ChessPiece current) {
		BoardTile[] ans = new BoardTile[kingMovements.length];
		int currentIdx = 0;
		for(String[] mov: kingMovements) {
			BoardTile check = board[cIndexOf(mov[0])][Integer.parseInt(mov[1])];
			if(current.getPieceType().substring(0, 1).equals("W")) {
				for(String[] t: bPieces[12].getCurrentTile().getKingMovements()) {
					if(!check.equals(board[cIndexOf(t[0])][Integer.parseInt(t[1])])) {
						ans[currentIdx] = check;
						currentIdx++;
					}
				}
			} else {
				for(String[] t: wPieces[12].getCurrentTile().getKingMovements()) {
					if(!check.equals(board[cIndexOf(t[0])][Integer.parseInt(t[1])])) {
						ans[currentIdx] = check;
						currentIdx++;
					}
				}
			}
		}
		BoardTile[] nAns = new BoardTile[currentIdx];
		currentIdx = 0;
		for(int i = 0; i<nAns.length; i++) {
			
			if(ans[i].getPiece() != null) {
				if(compareType(current, ans[i].getPiece())) {
					nAns[currentIdx] = ans[i];
					currentIdx ++;
				}
			} else {
				if(check(ans[i], current.getPieceType().substring(0, 1))) {
					nAns[currentIdx] = ans[i];
					currentIdx ++;
				}
			}
		}
		return ans;
	}

	private boolean check(BoardTile boardTile, String side) {
		boolean notBlocked = true;
		if(side.compareTo("W") == 0) {
			for(ArrayList<BoardTile> b: wVia) {
				for(BoardTile e: b) {
					if(e.equals(boardTile)) {
						notBlocked = false;
					}
				}
			}
		} else {
			for(ArrayList<BoardTile> b: bVia) {
				for(BoardTile e: b) {
					if(e.equals(boardTile)) {
						notBlocked = false;
					}
				}
			}
		}

		return notBlocked;
	}

	private BoardTile[] queenVia(String[][] queenMovements, String currentCol, int currentRow, ChessPiece piece) {
		BoardTile[] nW = checkNorthWest(queenMovements, currentCol, currentRow, piece );
		BoardTile[] nE = checkNorthEast(queenMovements, currentCol, currentRow, piece);
		BoardTile[] sW = checkSouthWest(queenMovements, currentCol, currentRow, piece);
		BoardTile[] sE = checkSouthEast(queenMovements, currentCol, currentRow, piece);
		BoardTile[] right = checkRight(queenMovements, currentCol,piece);
		BoardTile[] left = checkLeft( queenMovements, currentCol,piece);
		BoardTile[] top = checkTop( queenMovements, currentRow,piece);
		BoardTile[] bottom = checkBottom(queenMovements, currentRow, piece);
		BoardTile[] combine = append4Arrays(nW, nE, sW, sE);
		BoardTile[] combine2 = append4Arrays(bottom, right, left, top);
		BoardTile[] filler = new BoardTile[0];
		BoardTile[] filler1 = new BoardTile[0];
		return append4Arrays(combine, combine2, filler, filler1);
	}

	private BoardTile[] bishopVia(String[][] bishopMovements, String currentCol, int currentRow, ChessPiece piece) {
		BoardTile[] nW = checkNorthWest(bishopMovements, currentCol, currentRow, piece );
		BoardTile[] nE = checkNorthEast(bishopMovements, currentCol, currentRow, piece);
		BoardTile[] sW = checkSouthWest(bishopMovements, currentCol, currentRow, piece);
		BoardTile[] sE = checkSouthEast(bishopMovements, currentCol, currentRow, piece);
		return append4Arrays(nW, nE, sW, sE);
	}

	private BoardTile[] checkSouthEast(String[][] possibleMoves, String currentCol, int currentRow, ChessPiece piece) {
		int currentIdx = 0;
		for(int i =0; i< possibleMoves.length; i++){
			String[] key = possibleMoves[i];
			int j = i-1;
			while(j >= 0 && (possibleMoves[j][0].compareTo(key[0]) < 0 && Integer.parseInt(possibleMoves[j][1]) < Integer.parseInt(key[1]) )) {
				possibleMoves[j+ 1] = possibleMoves [j];
				j--;
			}
			possibleMoves[j +1] = key;
		}
		int length = 0;
		for( int i = 0; i< possibleMoves.length; i++) {
			if( currentCol.compareTo(possibleMoves[i][0]) > 0 || currentRow > Integer.parseInt(possibleMoves[i][1])) {
				length = i -1;
				break;
			}
		}
		BoardTile[] sorted = new BoardTile[length];
		for(int i = length; i>= 0; i--){
			BoardTile tile = board[cIndexOf(possibleMoves[i][0])][Integer.parseInt(possibleMoves[i][1])];
			if(tile.getPiece() != null) {
				if(compareType(piece, tile.getPiece())){
					sorted[currentIdx] = tile;
					currentIdx ++;
					break;
				}
			}
			else{
				sorted[currentIdx] = tile;
				currentIdx ++;
			}
		}
		return sorted;
	}

	private BoardTile[] checkSouthWest(String[][] possibleMoves, String currentCol, int currentRow, ChessPiece piece) {
		int currentIdx = 0;
		for(int i =0; i< possibleMoves.length; i++){
			String[] key = possibleMoves[i];
			int j = i-1;
			while(j >= 0 && (possibleMoves[j][0].compareTo(key[0]) > 0 && Integer.parseInt(possibleMoves[j][1]) < Integer.parseInt(key[1]) )) {
				possibleMoves[j+ 1] = possibleMoves [j];
				j--;
			}
			possibleMoves[j +1] = key;
		}
		int length = 0;
		for( int i = 0; i< possibleMoves.length; i++) {
			if( currentCol.compareTo(possibleMoves[i][0]) > 0 || currentRow > Integer.parseInt(possibleMoves[i][1])) {
				length = i -1;
				break;
			}
		}
		BoardTile[] sorted = new BoardTile[length];
		for(int i = length; i>= 0; i--){
			BoardTile tile = board[cIndexOf(possibleMoves[i][0])][Integer.parseInt(possibleMoves[i][1])];
			if(tile.getPiece() != null) {
				if(compareType(piece, tile.getPiece())){
					sorted[currentIdx] = tile;
					currentIdx ++;
					break;
				}
			}
			else{
				sorted[currentIdx] = tile;
				currentIdx ++;
			}
		}
		return sorted;
	}

	private BoardTile[] checkNorthEast(String[][] possibleMoves, String currentCol, int currentRow, ChessPiece piece) {
		int currentIdx = 0;
		for(int i =0; i< possibleMoves.length; i++){
			String[] key = possibleMoves[i];
			int j = i-1;
			while(j >= 0 && (possibleMoves[j][0].compareTo(key[0]) < 0 && Integer.parseInt(possibleMoves[j][1]) > Integer.parseInt(key[1]) )) {
				possibleMoves[j+ 1] = possibleMoves [j];
				j--;
			}
			possibleMoves[j +1] = key;
		}
		int length = 0;
		for( int i = 0; i< possibleMoves.length; i++) {
			if( currentCol.compareTo(possibleMoves[i][0]) > 0 || currentRow < Integer.parseInt(possibleMoves[i][1])) {
				length = i -1;
				break;
			}
		}
		BoardTile[] sorted = new BoardTile[length];
		for(int i = length; i>= 0; i--){
			BoardTile tile = board[cIndexOf(possibleMoves[i][0])][Integer.parseInt(possibleMoves[i][1])];
			if(tile.getPiece() != null) {
				if(compareType(piece, tile.getPiece())){
					sorted[currentIdx] = tile;
					currentIdx ++;
					break;
				}
			}
			else{
				sorted[currentIdx] = tile;
				currentIdx ++;
			}
		}
		return sorted;
	}

	private BoardTile[] checkNorthWest(String[][] possibleMoves, String currentCol, int currentRow, ChessPiece piece) {
		int currentIdx = 0;
		for(int i =0; i< possibleMoves.length; i++){
			String[] key = possibleMoves[i];
			int j = i-1;
			while(j >= 0 && (possibleMoves[j][0].compareTo(key[0]) > 0 && Integer.parseInt(possibleMoves[j][1]) > Integer.parseInt(key[1]) )) {
				possibleMoves[j+ 1] = possibleMoves [j];
				j--;
			}
			possibleMoves[j +1] = key;
		}
		int length = 0;
		for( int i = 0; i< possibleMoves.length; i++) {
			if( currentCol.compareTo(possibleMoves[i][0]) < 0 || currentRow < Integer.parseInt(possibleMoves[i][1])) {
				length = i -1;
				break;
			}
		}
		BoardTile[] sorted = new BoardTile[length];
		for(int i = length; i>= 0; i--){
			BoardTile tile = board[cIndexOf(possibleMoves[i][0])][Integer.parseInt(possibleMoves[i][1])];
			if(tile.getPiece() != null) {
				if(compareType(piece, tile.getPiece())){
					sorted[currentIdx] = tile;
					currentIdx ++;
					break;
				}
			}
			else{
				sorted[currentIdx] = tile;
				currentIdx ++;
			}
		}
		return sorted;
	}

	private BoardTile[] knightVia(String[][] knightMovements, ChessPiece current) {
		BoardTile[] ans = new BoardTile[knightMovements.length];
		int currentIdx = 0;
		for(int i =0; i< knightMovements.length; i ++) {
			BoardTile tile = board[cIndexOf(knightMovements[i][0])][Integer.parseInt(knightMovements[i][1])];
			if(tile.getPiece() != null) {
				if(compareType(current, tile.getPiece())){
					ans[currentIdx] = tile;
					currentIdx ++;
				}
			}
			else{
				ans[currentIdx] = tile;
				currentIdx ++;
			}
		}
		return ans;
	}

	//returns true if the type is different ie different side
	public boolean compareType(ChessPiece base, ChessPiece other) {
		if(base.getPieceType().substring(0, 1).compareTo(other.getPieceType().substring(0, 1)) != 0){
			return true;
		}
		return false;
	}
	public BoardTile[] rookVia(String[][] possibleMoves, String currentCol, int currentRow, ChessPiece check){
		BoardTile[] right = checkRight(possibleMoves, currentCol,check);
		BoardTile[] left = checkLeft( possibleMoves, currentCol,check);
		BoardTile[] top = checkTop( possibleMoves, currentRow,check);
		BoardTile[] bottom = checkBottom(possibleMoves, currentRow, check);
		BoardTile[] viableInputs = append4Arrays(right, left, top, bottom);
		return viableInputs;
	}

	private BoardTile[] append4Arrays(BoardTile[] arr1, BoardTile[] arr2, BoardTile[] arr3, BoardTile[] arr4) {
		int length = arr1.length + arr2.length + arr3.length + arr4.length;
		BoardTile[] ans = new BoardTile[length];

		int currentIdx =0;

		for( BoardTile e : arr1) {
			ans[currentIdx] = e;
			currentIdx ++;
		}

		for( BoardTile e: arr2) {
			ans[currentIdx] = e;
			currentIdx ++;
		}
		for( BoardTile e: arr3) {
			ans[currentIdx] = e;
			currentIdx ++;
		}
		for( BoardTile e: arr4) {
			ans[currentIdx] = e;
			currentIdx ++;
		}

		return ans;
	}

	private BoardTile[] checkBottom(String[][] possibleMoves, int currentRow, ChessPiece check) {
		int length = 0;
		for(int i = 0; i<possibleMoves.length -1 ; i++) {
			String[] change = possibleMoves[0];
			int idx = i;
			for(int j = i+1; j< possibleMoves.length; j++) {
				if(Integer.parseInt(possibleMoves[j][1]) > currentRow) {
					change = possibleMoves[j];
					idx = j;
				}
			}
			if(i == idx) {
				length = i;
				break;
			}
			String[] holder = change;
			possibleMoves[idx] = possibleMoves[i];
			possibleMoves[i] = holder;
		}
		BoardTile[] ans = new BoardTile[length];
		for(int i = 0; i < length; i++){
			if(board[cIndexOf(possibleMoves[i][0])][Integer.parseInt(possibleMoves[i][1])].getPiece() == null)
				ans[i] = board[cIndexOf(possibleMoves[i][0])][Integer.parseInt(possibleMoves[i][1])];
			else {
				if(compareType(board[cIndexOf(possibleMoves[i][0])][Integer.parseInt(possibleMoves[i][1])].getPiece(), check)) {
					ans[i] = board[cIndexOf(possibleMoves[i][0])][Integer.parseInt(possibleMoves[i][1])];
					break;
				} else break;
			}
		}
		return ans;
	}

	private BoardTile[] checkTop(String[][] possibleMoves, int currentRow, ChessPiece check) {
		int length = 0;
		for(int i = 0; i<possibleMoves.length -1 ; i++) {
			String[] change = possibleMoves[0];
			int idx = i;
			for(int j = i+1; j< possibleMoves.length; j++) {
				if(Integer.parseInt(possibleMoves[j][1]) < currentRow) {
					change = possibleMoves[j];
					idx = j;
				}
			}
			if(i == idx) {
				length = i;
				break;
			}
			String[] holder = change;
			possibleMoves[idx] = possibleMoves[i];
			possibleMoves[i] = holder;
		}
		BoardTile[] ans = new BoardTile[length];
		for(int i = 0; i < length; i++){
			if(board[cIndexOf(possibleMoves[i][0])][Integer.parseInt(possibleMoves[i][1])].getPiece() == null)
				ans[i] = board[cIndexOf(possibleMoves[i][0])][Integer.parseInt(possibleMoves[i][1])];
			else {
				if(compareType(board[cIndexOf(possibleMoves[i][0])][Integer.parseInt(possibleMoves[i][1])].getPiece(), check)) {
					ans[i] = board[cIndexOf(possibleMoves[i][0])][Integer.parseInt(possibleMoves[i][1])];
					break;
				} else break;
			}
		}
		return ans;
	}

	private BoardTile[] checkLeft(String[][] possibleMoves, String currentCol, ChessPiece check) {
		int length = 0;
		for(int i = 0; i<possibleMoves.length -1 ; i++) {
			String[] change = possibleMoves[0];
			int idx = i;
			for(int j = i+1; j< possibleMoves.length; j++) {
				if(possibleMoves[j][0].compareTo(change[0]) < 0) {
					change = possibleMoves[j];
					idx = j;
				}
			}
			if(i == idx) {
				length = i;
				break;
			}
			String[] holder = change;
			possibleMoves[idx] = possibleMoves[i];
			possibleMoves[i] = holder;
		}
		BoardTile[] ans = new BoardTile[length];
		for(int i = 0; i < length; i++){
			if(board[cIndexOf(possibleMoves[i][0])][Integer.parseInt(possibleMoves[i][1])].getPiece() == null)
				ans[i] = board[cIndexOf(possibleMoves[i][0])][Integer.parseInt(possibleMoves[i][1])];
			else {
				if(compareType(board[cIndexOf(possibleMoves[i][0])][Integer.parseInt(possibleMoves[i][1])].getPiece(), check)) {
					ans[i] = board[cIndexOf(possibleMoves[i][0])][Integer.parseInt(possibleMoves[i][1])];
					break;
				} else break;
			}
		}
		return ans;
	}

	private BoardTile[] checkRight(String[][] possibleMoves, String currentCol, ChessPiece check) {
		int length = 0;
		for(int i = 0; i<possibleMoves.length -1 ; i++) {
			String[] change = possibleMoves[0];
			int idx = i;
			for(int j = i+1; j< possibleMoves.length; j++) {
				if(possibleMoves[j][0].compareTo(change[0]) > 0) {
					change = possibleMoves[j];
					idx = j;
				}
			}
			if(i == idx) {
				length = i;
				break;
			}
			String[] holder = change;
			possibleMoves[idx] = possibleMoves[i];
			possibleMoves[i] = holder;
		}
		BoardTile[] ans = new BoardTile[length];
		for(int i = 0; i < length; i++){
			if(board[cIndexOf(possibleMoves[i][0])][Integer.parseInt(possibleMoves[i][1])].getPiece() == null)
				ans[i] = board[cIndexOf(possibleMoves[i][0])][Integer.parseInt(possibleMoves[i][1])];
			else {
				if(compareType(board[cIndexOf(possibleMoves[i][0])][Integer.parseInt(possibleMoves[i][1])].getPiece(), check)) {
					ans[i] = board[cIndexOf(possibleMoves[i][0])][Integer.parseInt(possibleMoves[i][1])];
					break;
				} else break;
			}
		}
		return ans;
	}

	public int cIndexOf(String alpha) {
		for(int i= 0; i< col.length; i++) {
			if(col[i].compareTo(alpha) == 0) {
				return i;
			}
		}
		return -1;
	}

	private void writeChessTiles() {
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


	public void populateBoard() {
		int currentWIdx = 0;
		int currentBIdx = 0;
		for(int row = 0; row< board.length; row ++) {
			for( int col = 0; col< board[row].length; col ++ ) {
				if(row == 1) {	
					ChessPiece piece = new ChessPiece("Pawn", new ImageIcon("Images/Pawn.png"), board[row][col]);
					board[row][col].setChessPiece(piece);
					wPieces[currentWIdx] = piece;
					currentWIdx ++;
				}
				if(row == 6) {
					ChessPiece piece = new ChessPiece("BPawn", new ImageIcon("Images/BPawn.png"), board[row][col]);
					board[row][col].setChessPiece(piece);
					bPieces[currentBIdx] = piece;
					currentBIdx ++;
				}
				if(row == 0) {
					ChessPiece piece = new ChessPiece(chessPieces[col], chessImages[col], board[row][col]);
					board[row][col].setChessPiece(piece);
					wPieces[currentWIdx] = piece;
					currentWIdx ++;
				}
				if(row == 7) {
					ChessPiece piece = new ChessPiece(chessPiecesB[col], BChessImages[col], board[row][col]);
					board[row][col].setChessPiece(piece);
					bPieces[currentBIdx] = piece;
					currentBIdx ++;
				}
			}
		}
	}
	public void giveMov() {
		for(int row =0; row<board.length; row++) {
			for( int col = 0; col< board[row].length; col++) {
				board[row][col].setBishopMovements(bishop(board[row][col]));
				board[row][col].setKingMovements(king(board[row][col]));
				board[row][col].setQueenMovements(queen(board[row][col]));
				board[row][col].setRookMovements(rook(board[row][col]));
				board[row][col].setKnightMovements(knight(board[row][col]));
				if( row > 0) {
					board[row][col].setwPawnMovements(wpawn(board[row][col]));
				}
				if( row < board.length -1 ) {
					board[row][col].setbPawnMovements(bpawn(board[row][col]));
				}
			}
		}
	}
	private String[][] bpawn(BoardTile current) {
		String[][] temp = new String[3][2];
		int alphaIndex = cIndexOf(current.getCol());
		int tempRow =0;
		if( current.getRow() -1 >= 0) {
			String[] iArray = {col[alphaIndex], Integer.toString(current.getRow() - 1)};
			temp[tempRow] = iArray;
			tempRow ++;

			if( alphaIndex +1 < board[current.getRow()].length) {
				String[] iArray2 = {col[alphaIndex +1], Integer.toString(current.getRow() - 1)};
				temp[tempRow] = iArray2;
				tempRow ++;
			}
			if( alphaIndex -1 >= 0) {
				String[] iArray3 =  {col[alphaIndex -1], Integer.toString(current.getRow() - 1)};
				temp[tempRow] = iArray3;
				tempRow++;
			}
		}
		if( current.getRow() == 7) {
			String[] iArray4  = {col[alphaIndex], Integer.toString(current.getRow() -2)};
			temp[tempRow] = iArray4;
		}
		return temp;
	}

	private String[][] wpawn(BoardTile current) {
		String[][] temp = new String[4][2];
		int alphaIndex = cIndexOf(current.getCol());
		int tempRow =0;
		if( current.getRow() -1 > 0) {
			String[] iArray = {col[alphaIndex], Integer.toString(current.getRow() + 1)};
			temp[tempRow] = iArray;
			tempRow ++;
			if( alphaIndex +1 < board[current.getRow()].length){
				String[] iArray2 = {col[alphaIndex +1], Integer.toString(current.getRow() + 1)};
				temp[tempRow] = iArray2;
				tempRow ++;
			}
			if( alphaIndex -1 >= 0) {
				String[] iArray3 =  {col[alphaIndex -1], Integer.toString(current.getRow() + 1)};
				temp[tempRow] = iArray3;
				tempRow++;
			}
		}
		if( current.getRow() == 1 ) {
			String[] iArray4 = {col[alphaIndex], Integer.toString(current.getRow()+2)};
			temp[tempRow] = iArray4;
		}
		return temp;
	}

	private String[][] knight(BoardTile current) {
		String[][] temp = new String[8][2];
		int alphaIndex = cIndexOf(current.getCol());
		int tempRow =0;
		if(alphaIndex - 1 > 0) {
			if( current.getRow() -2 >= 0) {
				String[] iArray = {col[alphaIndex -1], Integer.toString(current.getRow() - 2)};
				temp[tempRow] = iArray;
				tempRow ++;
			}
			if( current.getRow() +2 < board.length) {
				String[] iArray = {col[alphaIndex -1], Integer.toString(current.getRow() + 2)};
				temp[tempRow] = iArray;
				tempRow ++;
			}
		}
		if(alphaIndex - 2 > 0) {
			if( current.getRow() -1 >= 0)
			{
				String[] iArray = {col[alphaIndex -2], Integer.toString(current.getRow() - 1)};
				temp[tempRow] = iArray;
				tempRow ++;
			}
			if( current.getRow() +1 < board.length) {
				String[] iArray = {col[alphaIndex -2], Integer.toString(current.getRow() + 1)};
				temp[tempRow] = iArray;
				tempRow ++;
			}
		}
		if(alphaIndex + 1 < col.length)
		{
			if( current.getRow() -2 >= 0)
			{
				String[] iArray = {col[alphaIndex +1], Integer.toString(current.getRow() - 2)};
				temp[tempRow] = iArray;
				tempRow ++;
			}
			if( current.getRow() +2 < board.length)
			{
				String[] iArray = {col[alphaIndex +1], Integer.toString(current.getRow() + 2)};
				temp[tempRow] = iArray;
				tempRow ++;
			}
		}
		if(alphaIndex + 2 < col.length)
		{
			if( current.getRow() -1 >= 0)
			{
				String[] iArray = {col[alphaIndex +2], Integer.toString(current.getRow() - 1)};
				temp[tempRow] = iArray;
				tempRow ++;
			}
			if( current.getRow() +1 < board.length)
			{
				String[] iArray = {col[alphaIndex +2], Integer.toString(current.getRow() + 1)};
				temp[tempRow] = iArray;
				tempRow ++;
			}
		}
		return temp;
	}

	private String[][] rook(BoardTile current) {
		String[][] temp = new String[14][2];
		int alphaIndex = cIndexOf(current.getCol());
		int tempRow =0;
		if(alphaIndex < board.length)
		{
			for(int i= 1; i+ alphaIndex< board.length; i++)
			{
				String[] iArray = {col[alphaIndex +i], Integer.toString(current.getRow())};
				temp[tempRow] = iArray;
				tempRow ++;
			}
		}
		if(alphaIndex > 0)
		{
			for(int i =1; alphaIndex - i > 0; i++)
			{
				String[] iArray = {col[alphaIndex-i], Integer.toString(current.getRow())};
				temp[tempRow] = iArray;
				tempRow ++;
			}
		}
		if(current.getRow() > 0)
		{
			for(int i=1; alphaIndex-i >0; i++)
			{
				String[] iArray = {col[alphaIndex], Integer.toString(current.getRow()-i)};
				temp[tempRow] = iArray;
				tempRow ++;
			}
		}
		if(current.getRow() <board.length)
		{
			for(int i=1; alphaIndex+i < board.length; i++)
			{
				String[] iArray = {col[alphaIndex], Integer.toString(current.getRow()+i)};
				temp[tempRow] = iArray;
				tempRow ++;
			}
		}
		return temp;
	}

	public String[][] queen(BoardTile current)
	{
		String[][] temp = new String[27][2];
		int alphaIndex = cIndexOf(current.getCol());
		int tempRow =0;
		if(alphaIndex < board.length)
		{
			for(int i= 1; i+ alphaIndex< board.length; i++)
			{
				String[] iArray = {col[alphaIndex +i], Integer.toString(current.getRow())};
				temp[tempRow] = iArray;
				tempRow ++;
			}
		}
		if(alphaIndex > 0)
		{
			for(int i =1; alphaIndex - i > 0; i++)
			{
				String[] iArray = {col[alphaIndex-i], Integer.toString(current.getRow())};
				temp[tempRow] = iArray;
				tempRow ++;
			}
		}
		if(current.getRow() > 0)
		{
			for(int i=1; alphaIndex-i >0; i++)
			{
				String[] iArray = {col[alphaIndex], Integer.toString(current.getRow()-i)};
				temp[tempRow] = iArray;
				tempRow ++;
			}
		}
		if(current.getRow() <board.length)
		{
			for(int i=1; alphaIndex+i < board.length; i++)
			{
				String[] iArray = {col[alphaIndex], Integer.toString(current.getRow()+i)};
				temp[tempRow] = iArray;
				tempRow ++;
			}
		}
		for(int i = 1; i<8; i++)
		{
			if( alphaIndex- i> 0)
			{
				if(current.getRow() -i> 0)
				{
					String[] iArray = {col[alphaIndex-i], Integer.toString(current.getRow()-i)};
					temp[tempRow] = iArray; 
					tempRow ++;
				}
				if( current.getRow() + i< board.length )
				{
					String[] iArray = {col[alphaIndex-i], Integer.toString(current.getRow() + i)};
					temp[tempRow] = iArray;
					tempRow++;
				}
			}

			if( alphaIndex + i < col.length)
			{
				if(current.getRow() -i> 0)
				{
					String[] iArray = {col[alphaIndex + i], Integer.toString(current.getRow()-i)};
					temp[tempRow] = iArray;
					tempRow++;
				}
				if(current.getRow() +i< board.length)
				{	
					String[] iArray = {col[alphaIndex + i], Integer.toString(current.getRow()+i)};
					temp[tempRow] = iArray;
					tempRow++;
				}

			}

		}
		return temp;

	}
	public String[][] king(BoardTile current)
	{
		String[][] temp = new String[8][2];
		int alphaIndex = cIndexOf(current.getCol());
		int tempRow =0;
		if(alphaIndex - 1 > 0)
		{
			if( current.getRow() -1 > 0)
			{
				String[] iArray = {col[alphaIndex -1], Integer.toString(current.getRow() - 1)};
				temp[tempRow] = iArray;
				tempRow ++;
			}
			if( current.getRow() +1 < board.length)
			{
				String[] iArray = {col[alphaIndex -1], Integer.toString(current.getRow() + 1)};
				temp[tempRow] = iArray;
				tempRow ++;
			}
			String[] iArray = {col[alphaIndex -1], Integer.toString(current.getRow())};
			temp[tempRow] = iArray;
			tempRow ++;
		}
		if(alphaIndex + 1 < col.length)
		{
			if( current.getRow() -1 > 0)
			{
				String[] iArray = {col[alphaIndex +1], Integer.toString(current.getRow() - 1)};
				temp[tempRow] = iArray;
				tempRow ++;
			}
			if( current.getRow() +1 < board.length)
			{
				String[] iArray = {col[alphaIndex +1], Integer.toString(current.getRow() + 1)};
				temp[tempRow] = iArray;
				tempRow ++;
			}
			String[] iArray = {col[alphaIndex +1], Integer.toString(current.getRow())};
			temp[tempRow] = iArray;
			tempRow ++;
		}
		if( current.getRow() -1> 0)
		{
			String[] iArray = {col[alphaIndex ], Integer.toString(current.getRow()-1)};
			temp[tempRow] = iArray;
			tempRow ++;
		}
		if( current.getRow() +1 < board.length)
		{
			String[] iArray = {col[alphaIndex ], Integer.toString(current.getRow()+1)};
			temp[tempRow] = iArray;
			tempRow ++;
		}
		return temp;
	}
	public String[][] bishop(BoardTile current)
	{

		String[][] temp = new String[13][2];
		int tempRow = 0;
		int alphaIndex = cIndexOf(current.getCol());
		for(int i = 1; i<8; i++)
		{
			if( alphaIndex- i> 0)
			{
				if(current.getRow() -i> 0)
				{
					String[] iArray = {col[alphaIndex-i], Integer.toString(current.getRow()-i)};
					temp[tempRow] = iArray; 
					tempRow ++;
				}
				if( current.getRow() + i< board.length )
				{
					String[] iArray = {col[alphaIndex-i], Integer.toString(current.getRow() + i)};
					temp[tempRow] = iArray;
					tempRow++;
				}
			}

			if( alphaIndex + i < col.length) {
				if(current.getRow() -i> 0) {
					String[] iArray = {col[alphaIndex + i], Integer.toString(current.getRow()-i)};
					temp[tempRow] = iArray;
					tempRow++;
				}
				if(current.getRow() +i< board.length) {	
					String[] iArray = {col[alphaIndex + i], Integer.toString(current.getRow()+i)};
					temp[tempRow] = iArray;
					tempRow++;
				}

			}

		}

		return temp;
	}

	public void move(ChessPiece piece, BoardTile target, BoardTile previous){
		target.setChessPiece(piece);
		previous.setChessPiece(null);
	}

	public BoardTile[][] getBoard(){
		return board;
	}

	public String[] getChessPieces() {
		return chessPieces;
	}
}