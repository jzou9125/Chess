package chessGUI;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import chessBoard.ChessBoard;

public class GUI {

	public GUI() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ImageIcon[] tileFile = {new ImageIcon("Images/White Tile.png"), new ImageIcon("Images/Black Tile.png")};
		JFrame f = new JFrame();
		f.setLayout(new FlowLayout());
		f.setVisible(true);
		f.setSize(1000, 1000);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FlowLayout mLayout = new FlowLayout();

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
					JLabel tile = new JLabel(tileFile[i%2]);
					chessBoard.add(tile,c);
				}
			}
		}
		f.add(chessBoard, mLayout);


		JTable scoreBoard = new JTable(new DefaultTableModel(new Object[]{"Turn","White Action", "Black Action", "Points"}, 0));
		JScrollPane scroll = new JScrollPane(scoreBoard);

		f.add(scroll, mLayout);

		f.pack();
		f.revalidate();
		f.repaint();


	}

}
