
public class Paddle {

	boolean isLeft;
	int xPosition;
	int yPosition = 225;
	int height = 125;
	int width = 25;
	
	public Paddle(boolean isLeft){
		if(isLeft){
			xPosition = 50;
		} else {
			xPosition = 750 - width;
		}
	}
	
	public int getX(){
		return xPosition;
	}
	
	public int getY(){
		return yPosition;
	}
	
	public void translate(int num){
		yPosition -= num;
		if(yPosition < 0){
			yPosition = 0;
		} else if(yPosition > 580 - height){
			yPosition = 580 - height;
		}
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
	
}
