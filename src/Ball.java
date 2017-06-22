import java.util.Random;

public class Ball implements Runnable {

	PongPanel panel;
	private Thread t;
	int size = 10;
	int xPosition = 400 - (size / 2);
	int yPosition = 300 - (size / 2);
	int xSpeed;
	int ySpeed;
	int player1Score = 0;
	int player2Score = 0;
	
	int[][] directionSlopes = {{1, 1},{-1, 1}, {-1, -1},{1, -1}};
	
	public Ball(PongPanel p){
		Random rand = new Random();
		panel = p;
		int index = rand.nextInt(directionSlopes.length);
		
		xSpeed = directionSlopes[index][0];
		ySpeed = directionSlopes[index][1];
	}
	
	public int getX(){
		return xPosition;
	}
	
	public int getY(){
		return yPosition;
	}
	
	public int getSize(){
		return size;
	}
	
	private boolean isCollidingWithLeftPaddle(){
		if(xPosition <= 75 && xPosition >= 70 && (yPosition >= panel.leftPaddle.getY() && yPosition <= panel.leftPaddle.getY() + 125) && xSpeed < 0){
			return true;
		}
			return false;
	}
	
	private boolean isCollidingWithRightPaddle(){
		if(xPosition + size >= 725 && xPosition + size <= 730 && (yPosition >= panel.rightPaddle.getY() && yPosition <= panel.rightPaddle.getY() + 125) && xSpeed > 0){
			return true;
		}
		return false;
	}
	
	private boolean isColliding() {
		if (xPosition <= 0 || xPosition >= 800 - size || yPosition <= 0 || yPosition >= 580 - size) {
			return true;
		}
		return false;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
		}
		
		while(true){
			xPosition += xSpeed;
			yPosition -= ySpeed;
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				
			}
			
			if(isCollidingWithLeftPaddle() || isCollidingWithRightPaddle()){
				xSpeed *= -1;
			}
			
			if(isColliding()){
				if(xPosition > 0 && xPosition < 800 - size){
					ySpeed *= -1;
				} else {
					if(xPosition <= 0){
						player2Score++;
					} else {
						player1Score++;
					}
					xPosition = 400 - size;
					yPosition = 300 - size;
					
					Random rand = new Random();
					int index = rand.nextInt(directionSlopes.length);
					xSpeed = directionSlopes[index][0];
					ySpeed = directionSlopes[index][1];
				}
			}
			panel.repaint();
		}
		
	}
	
	public void start(){
		System.out.println("starting");
		if(t == null){
			t = new Thread(this, "ballMovement");
			t.start();
		}
	}
	
}
