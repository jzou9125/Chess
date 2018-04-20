package chessBoard;

public class ChessBoard {

	BoardTile[][] board = new BoardTile[8][8];
	public static final String[] col = {"A", "B", "C", "D", "E", "F", "G", "H"};
	String[] chessPieces = {"Rook", "Knight", "Bishop", "Queen", "King"};
	String[] chessAddress = {};
	public ChessBoard() {
		for(int row =0; row< board.length; row++ )
		{
			for( int col = 0; col< board[row].length; col ++)
			{
				board[row][col] = new BoardTile(null, null, this.col[col], row);
			}
		}
	}
	
	public void populateBoard() {
		for(int row = 0; row< board.length; row ++)
		{
			for( int col = 0; col< board[row].length; col ++ )
			{
				if(row%5 == 1 )
				{
					board[row][col].setChessPiece(new ChessPiece("Pawn", null));
				}
				if(row%7 == 0 )
				{
					board[row][col].setChessPiece(new ChessPiece(chessPieces[col%5], null));
				}
				
			}
		}
	}
	
	public void move(ChessPiece piece, BoardTile target, BoardTile previous)
	{
		target.setChessPiece(piece);
		previous.setChessPiece(null);
	}

}
