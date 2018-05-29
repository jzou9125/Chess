package chessGUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import chessBoard.ChessBoard;
import game.Starter;

public class GUI {

	private JFrame f;
	private JLayeredPane chessW;
	private ChessBoard b;
	private JScrollPane scroll;
	private GridLayout l;
	
	private JPanel currentScreen; // three screens (Load, and the Board)
	private JPanel loadScreen;
	private JPanel mainScreen;
	
	public GUI(ChessBoard board) {
		b = board;
		f = new JFrame();
		l = new GridLayout(1,2);
		f.setLayout(l);
		f.setVisible(true);
		f.setSize(1000, 1000);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		redrawBoard();
		
		f.pack();
		f.revalidate();
		f.repaint();
	}
	public void updateBoard()
	{
		redrawBoard();
		f.pack();
		f.revalidate();
		f.repaint();

	}
	public void redrawBoard()
	{
		
		if( chessW != null)
		{
			f.remove(chessW);
		}
		if(scroll != null)
		{
			f.remove(scroll);
		}
		
		JTable scoreBoard = new JTable(new DefaultTableModel(new String[]{"Turn","White Action", "Black Action", "Points"}, 0));
		scroll = new JScrollPane(scoreBoard);
		
		chessW = new JLayeredPane();
		chessW.setPreferredSize(new Dimension(f.getWidth(), f.getHeight()));

		JPanel chessBoard = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;
		for(int i = 1; i< 81; i++)
		{
			c.gridy = (i%9);
			c.gridx = (i/9);
			if(c.gridx == 0)
			{
				JLabel alpha = new JLabel(ChessBoard.col[c.gridy -1]);
				chessBoard.add(alpha,c);
			}
			else
			{
				if(c.gridy == 0)
				{
					JLabel num = new JLabel(Integer.toString(c.gridx));
					num.setHorizontalAlignment(JLabel.CENTER);;
					chessBoard.add(num,c);
				}
				else
				{
					JLabel tile = new JLabel(b.getBoard()[c.gridy-1][c.gridx-1].getTileImage());
					chessBoard.add(tile,c);
					if(b.getBoard()[c.gridy -1][c.gridx-1].getPiece() != null)
					{
						ImageIcon imgI = b.getBoard()[c.gridy -1][c.gridx -1].getPiece().getPieceImage();
						Image img = imgI.getImage();
						Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
						imgI = new ImageIcon(newimg);
						JLabel piece = new JLabel(imgI);
						chessW.setLayer(piece, JLayeredPane.POPUP_LAYER);
						chessW.add(piece);
						piece.setBounds(c.gridx *100-20, c.gridy *100 -20, tile.getIcon().getIconWidth(), tile.getIcon().getIconHeight());

					}
				}
			}
		}
		chessW.setLayer(chessBoard, JLayeredPane.DEFAULT_LAYER);
		chessW.add(chessBoard);
		chessBoard.setBounds(0, 0,950, 950);

		f.add(chessW, l);
		f.add(scroll, l);
	}

}
