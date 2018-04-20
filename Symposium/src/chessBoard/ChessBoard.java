package chessBoard;

import javax.swing.ImageIcon;

public class ChessBoard {

	private BoardTile[][] board = new BoardTile[8][8];
	public static final String[] col = {"A", "B", "C", "D", "E", "F", "G", "H"};
	private String[] chessPieces = {"Rook", "Knight", "Bishop", "Queen", "King"};
	private ImageIcon[] chessImages = {new ImageIcon("Images/Rook.png"), new ImageIcon("Images/Knight.png"), new ImageIcon("Images/Bishop.png")
			, new ImageIcon("Images/Queen.png"), new ImageIcon("Images/King.png")};
	
	public ChessBoard() {
		for(int row =0; row< board.length; row++ )
		{
			for( int col = 0; col< board[row].length; col ++)
			{
				board[row][col] = new BoardTile(null, null, this.col[col], row);
			}
		}
		populateBoard();
	}
	
	public void populateBoard() {
		for(int row = 0; row< board.length; row ++)
		{
			for( int col = 0; col< board[row].length; col ++ )
			{
				if(row%5 == 1 )
				{
					
					board[row][col].setChessPiece(new ChessPiece("Pawn", new ImageIcon("Images/Pawn.png")));
				}
				if(row%7 == 0 )
				{
					board[row][col].setChessPiece(new ChessPiece(chessPieces[col%5], chessImages[col%5]));
				}
				
			}
		}
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
