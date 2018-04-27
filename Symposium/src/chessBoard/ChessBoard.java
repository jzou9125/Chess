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
		for(int row =0; row< board.length; row++ )
		{
			for( int col = 0; col< board[row].length; col ++)
			{
				board[row][col] = new BoardTile(null, tileFile[col%2], this.col[col], row);
			}
		}
		populateBoard();
		giveMov();
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
				}
			}
		}
	}
	public String[][] bishop(BoardTile current)
	{

		String[][] temp = new String[13][2];
		for(int i = 1; i<8; i++)
		{
			if(CindexOf(current.getCol()) - i > 0)
			{
				String[] 
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
