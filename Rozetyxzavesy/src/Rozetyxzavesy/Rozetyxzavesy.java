package Rozetyxzavesy;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

public class Rozetyxzavesy {
	
	public static void main(String[] args) throws InterruptedException {
	
	// Beginning state of results
		
		float leftNum = 0;
		float rightNum = 0;
		float result = rightNum / leftNum * 100;	
		
	//prints stuff to monitor
		
		Graphics c = new Graphics();

			c.window (result);
			Thread.sleep(1000);
			c.leftChange(leftNum); 
			c.rightChange(rightNum);
			c.logo();
			c.setVisible();
			Thread.sleep(1000);
			c.result(result);
			c.setVisible();
			
	// responds to mouse events, calls graphics functions
			
		MouseListener m = new MouseListener() {

			//@Override
			public void mouseClicked(MouseEvent e) {
				
				Graphics n = new Graphics();
				float leftNum = 0;
				float rightNum = 0;
				float result = rightNum / leftNum * 100;
				
				if (SwingUtilities.isLeftMouseButton(e)) {
					
					leftNum++;
					n.leftChange(leftNum);
					n.result(result);
				}
				else if (SwingUtilities.isRightMouseButton(e)) {
					rightNum++;
					n.leftChange(rightNum);
					n.result(result);
				}
				else if (SwingUtilities.isMiddleMouseButton(e)) {
					result = 0;
					n.result(result);
				}
			}
			//@Override
			public void mousePressed(MouseEvent e) {
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {				
			}
			
		};
		
	}
}
