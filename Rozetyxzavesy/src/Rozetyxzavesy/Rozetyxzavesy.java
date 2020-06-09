package Rozetyxzavesy;

import java.awt.event.MouseEvent;

public class Rozetyxzavesy {
	
	public static void main(String[] args) throws InterruptedException {
	
	// Beginning state of results
		
		float leftNum = 75;
		float rightNum = 60;
		float result = rightNum / leftNum * 100;	
		
		
		
	//prints stuff to monitor
		
		Graphics c = new Graphics();

			c.window (result);
			Thread.sleep(1000);
			c.leftChange(leftNum); 
			c.rightChange(rightNum);
			c.setVisible();
			Thread.sleep(1000);
			c.result(result);
			c.setVisible();
			
			
	// responds to mouse events, calls graphics functions
			
		Mouse m = new Mouse();
		
		Run r = new Run();
		
	}
}
