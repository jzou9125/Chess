package chessGUI;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import chessBoard.ChessBoard;

public class GUI {

	public GUI() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setVisible(true);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel chessBoard = new JPanel(new GridBagLayout() );
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		for(int i = 1; i< 82; i++)
		{
			c.gridy = i%9;
			c.gridx = i/9;
			if(c.gridx == 0)
			{
				JLabel alpha = new JLabel(ChessBoard.col[c.gridy]);
				chessBoard.add(alpha);
			}
			else
			{
				if(c.gridy == 0)
				{
					JLabel num = new JLabel(Integer.toString(c.gridx-1));
					chessBoard.add(num);
				}
				else
				{
					JLabel tile = new JLabel(new ImageIcon()); // add iamge later

					chessBoard.add(tile);
				}
			}
		}
		f.add(chessBoard);

		String[] colNames = {"Turn","White Action", "Black Action", "Points"};
		JTable scoreBoard = new JTable(null, colNames);
		scoreBoard.setVisible(true);
		f.add(scoreBoard);
		
		
	}

}
