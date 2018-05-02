package chessBoard;

import java.lang.reflect.Array;

import javax.swing.ImageIcon;

public class ChessBoard {

	private BoardTile[][] board = new BoardTile[8][8];
	public static final String[] col = {"A", "B", "C", "D", "E", "F", "G", "H"};
	private String[] chessPieces = {"Rook", "Knight", "Bishop", "Queen", "King", "Bishop","Knight","Rook"};
	private ImageIcon[] chessImages = {new ImageIcon("Images/Rook.png"), new ImageIcon("Images/Knight.png"), new ImageIcon("Images/Bishop.png")
			, new ImageIcon("Images/Queen.png"), new ImageIcon("Images/King.png"),new ImageIcon("Images/Bishop.png"),
			new ImageIcon("Images/Knight.png"), new ImageIcon("Images/Rook.png")};
	private ImageIcon[] BChessImages = {new ImageIcon("Images/BRook.png"), new ImageIcon("Images/BKnight.png"), new ImageIcon("Images/BBishop.png")
			, new ImageIcon("Images/BQueen.png"), new ImageIcon("Images/BKing.png"),new ImageIcon("Images/BBishop.png"),
			new ImageIcon("Images/BKnight.png"), new ImageIcon("Images/BRook.png")};
	private ImageIcon[] tileFile = {new ImageIcon("Images/White Tile.png"), new ImageIcon("Images/Black Tile.png")};
	
	public ChessBoard() {
		int i = 0;
		for(int row =0; row< board.length; row++ )
		{
			for( int col = 0; col< board[row].length; col ++)
			{
				board[row][col] = new BoardTile(null, tileFile[i%2], this.col[col], row);
				i++;
			}
		}
		populateBoard();
//		giveMov();
	}

	public void populateBoard() {
		for(int row = 0; row< board.length; row ++)
		{
			for( int col = 0; col< board[row].length; col ++ )
			{
				if(row == 1)
				{	
					board[row][col].setChessPiece(new ChessPiece("Pawn", new ImageIcon("Images/Pawn.png")));
				}
				if(row == 6)
				{
					board[row][col].setChessPiece(new ChessPiece("Pawn", new ImageIcon("Images/BPawn.png")));
				}
				if(row == 0)
				{
					board[row][col].setChessPiece(new ChessPiece(chessPieces[col], chessImages[col]));
				}
				if(row == 7)
				{
					board[row][col].setChessPiece(new ChessPiece(chessPieces[col], BChessImages[col]));
				}

			}
		}
	}
	public void giveMov()
	{
		for(int whole =0; whole < 81; whole++)
		{
			for(int row =0; row<board.length; row++)
			{
				for( int col = 0; col< board[row].length; col++)
				{
					board[row][col].setBishopMovements(bishop(board[row][col]));
					board[row][col].setKingMovements(king(board[row][col]));
					board[row][col].setQueenMovements(queen(board[row][col]));
					board[row][col].setRookMovements(rook(board[row][col]));
					board[row][col].setKnightMovements(knight(board[row][col]));
//					board[row][col].setwPawnMovements(wpawn(board[row][col]));
				}
			}
		}
	}
	/*private String[][] wpawn(BoardTile current) {
		String[][] temp = new String[8][2];
		int alphaIndex = CindexOf(current.getCol());
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
	}*/

	private String[][] knight(BoardTile current) {
		String[][] temp = new String[8][2];
		int alphaIndex = CindexOf(current.getCol());
		int tempRow =0;
		
		if(alphaIndex - 1 > 0)
		{
			if( current.getRow() -2 > 0)
			{
				String[] iArray = {col[alphaIndex -1], Integer.toString(current.getRow() - 2)};
				temp[tempRow] = iArray;
				tempRow ++;
			}
			if( current.getRow() +2 < board.length)
			{
				String[] iArray = {col[alphaIndex -1], Integer.toString(current.getRow() + 2)};
				temp[tempRow] = iArray;
				tempRow ++;
			}
		}
		if(alphaIndex - 2 > 0)
		{
			if( current.getRow() -1 > 0)
			{
				String[] iArray = {col[alphaIndex -2], Integer.toString(current.getRow() - 1)};
				temp[tempRow] = iArray;
				tempRow ++;
			}
			if( current.getRow() +1 < board.length)
			{
				String[] iArray = {col[alphaIndex -2], Integer.toString(current.getRow() + 1)};
				temp[tempRow] = iArray;
				tempRow ++;
			}
		}
		if(alphaIndex + 1 < col.length)
		{
			if( current.getRow() -2 > 0)
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
			if( current.getRow() -1 > 0)
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
		int alphaIndex = CindexOf(current.getCol());
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
		int alphaIndex = CindexOf(current.getCol());
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
		int alphaIndex = CindexOf(current.getCol());
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
		int alphaIndex = CindexOf(current.getCol());
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

	public int CindexOf(String alpha)
	{
		for(int i= 0; i< col.length; i++)
		{
			if(col[i].compareTo(alpha) == 0)
			{
				return i;
			}
		}
		return -1;
	}
	public void move(ChessPiece piece, BoardTile target, BoardTile previous)
	{
		target.setChessPiece(piece);
		previous.setChessPiece(null);
	}

	public BoardTile[][] getBoard() {
		return board;
	}


}
