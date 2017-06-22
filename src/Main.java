import javax.swing.*;

import java.awt.Color;

public class Main extends JFrame {
	
	static PongPanel pong = new PongPanel();
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		pong = new PongPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.DARK_GRAY);
		frame.setSize(800, 600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(pong);
		pong.ball.start();
		frame.setVisible(true);
	}

}
