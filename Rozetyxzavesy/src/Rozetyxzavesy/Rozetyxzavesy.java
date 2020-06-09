package Rozetyxzavesy;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Rozetyxzavesy {
	
	public static void main(String[] args) throws InterruptedException {
		
		int leftNum = 0;
		int rightNum = 0;
		int result = 0;		
		
		Counting c = new Counting ();
			c.window ();
			Thread.sleep(1000);
			c.leftChange(leftNum); 
			//c.RightChange(rightNum); 	
			//c.result = (result);
			
		//if(mouse)
	}
}
class Counting{
	JFrame window;
	Container con;
	JPanel leftNamePanel;
	JLabel leftNameLabel;
	JPanel Label;
	JLabel rightNameLabel;
	Font leftFont = new Font("Times new Roman" , Font.PLAIN, 150);	
	
	public void window() {
		window = new JFrame();
		window.setSize(1200, 900);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		con = window.getContentPane();
		window.setVisible(true);
	}
	public void leftChange(int leftNum) {	
		leftNamePanel = new JPanel();
		leftNamePanel.setBounds(10, 100, 600, 250);
		leftNamePanel.setBackground(Color.yellow);
		
		leftNameLabel = new JLabel ("Rozety :" + leftNum);
		leftNameLabel.setForeground(Color.black);
		leftNameLabel.setFont(leftFont);
		
		leftNamePanel.add(leftNameLabel);
		con.add(leftNamePanel);	
		leftNamePanel.setVisible(true);
		window.setVisible(true);
	}
}
	/*public void RightChange(int rightNum) {
		rightNamePanel = new JPanel();
		rightNamePanel.setBounds(10, 100, 600, 150);
		rightNamePanel.setBackground(Color.blue);
		rightNameLabel = new JLabel ("Závìsy" + rightNum);
		rightNamePanel.setForeground(Color.white);
		rightNamePanel.setFont(leftFont);
		rightNamePanel.add(rightNamePanel);
		con.add(rightNamePanel);	
		rightNamePanel.setVisible(true);
	}
	
}
public class Mouse implements MouseListener {
	Mouse.addMouseListener(this);
    void addMouseListener(this);


public void mousePressed(MouseEvent e) {
   saySomething("Mouse pressed; # of clicks: "
                + e.getClickCount(), e);
}
public void mouseReleased(MouseEvent e) {
   saySomething("Mouse released; # of clicks: "
                + e.getClickCount(), e);
}
public void mouseEntered(MouseEvent e) {
   saySomething("Mouse entered", e);
}
public void mouseExited(MouseEvent e) {
   saySomething("Mouse exited", e);
}
public void mouseClicked(MouseEvent e) {
   saySomething("Mouse clicked (# of clicks: "
                + e.getClickCount() + ")", e);
}
void saySomething(String eventDescription, MouseEvent e) {
    textArea.append(eventDescription + " detected on "
                    + e.getComponent().getClass().getName()
                    + "." + newline);
}
}

*/