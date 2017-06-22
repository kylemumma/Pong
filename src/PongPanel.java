import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class PongPanel extends JPanel implements KeyListener {
	
	Paddle leftPaddle = new Paddle(true);
	Paddle rightPaddle = new Paddle(false);
	Ball ball = new Ball(this);
	
	public PongPanel(){
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public void paintComponent(Graphics g){
		//Clear
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 800, 600);
		
		//Midline
		g.setColor(Color.LIGHT_GRAY);
		for(int i = 4; i < 600; i += 20){
			g.fillRect(398, i, 5, 10);
		}
		
		//Paddles and Ball
		g.setColor(Color.WHITE);
		g.fillRect(leftPaddle.getX(), leftPaddle.getY(), leftPaddle.getWidth(), leftPaddle.getHeight()); //left paddle
		g.fillRect(rightPaddle.getX(), rightPaddle.getY(), rightPaddle.getWidth(), rightPaddle.getHeight()); //right paddle
		g.fillRect(ball.getX(), ball.getY(), ball.getSize(), ball.getSize()); //ball
		
		//Scores
		Font font = new Font("Courier New", 50, 50);
		g.setFont(font);
		if(ball.player1Score == 0){
			g.drawString("0", 350 , 50); //player 1 score
		} else {
			g.drawString(Integer.toString(ball.player1Score), 350 - ((int) (Math.log10(ball.player1Score)) * 25), 50); //player 1 score
		}
		g.drawString(Integer.toString(ball.player2Score), 420, 50); //player 2 score
	}
	
	public void update(int keyCode){
		if(keyCode == 192){
			leftPaddle.translate(5);
		} else if(keyCode == KeyEvent.VK_TAB){
			leftPaddle.translate(-5);
		} else if(keyCode == KeyEvent.VK_UP){
			rightPaddle.translate(5);
		} else if(keyCode == KeyEvent.VK_DOWN){
			rightPaddle.translate(-5);
		}
		
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//NOT USING THIS METHOD	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		update(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//NOT USING THIS METHOD
	}

}
