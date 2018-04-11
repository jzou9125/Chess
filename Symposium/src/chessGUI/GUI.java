package chessGUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {

	public GUI() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setVisible(true);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setUndecorated(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel chessBoard = new JPanel(); 
		for(int i = 0; i< 65; i++)
		{
			chessBoard.add( new ImageIcon(null));
		}
	}

}
