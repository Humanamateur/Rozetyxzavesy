package Rozetyxzavesy;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Graphics{
	JFrame window;
	Container con;
	JPanel leftNamePanel;
	JLabel leftNameLabel;
	
	JPanel rightNamePanel;
	JLabel rightNameLabel;
	
	JPanel resultNamePanel;
	JLabel resultNameLabel;
	Font rzFont = new Font("Arial" , Font.PLAIN, 50);
	Font resultFont = new Font("Times new Roman" , Font.PLAIN, 50);
	
	public void window() {
		window = new JFrame();
		window.setSize(1600, 900);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.red);
		//window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//window.setUndecorated(true);
		window.setLayout(null);
		
		con = window.getContentPane();
		window.setVisible(true);
	}
	public void leftChange(int leftNum) {	
		leftNamePanel = new JPanel();
		leftNamePanel.setBounds(50, 100, 350, 300);
		leftNamePanel.setBackground(Color.white);
		
		leftNameLabel = new JLabel ("Rozety : " + leftNum);
		leftNameLabel.setForeground(Color.black);
		leftNameLabel.setFont(rzFont);
		
		leftNamePanel.add(leftNameLabel);
		con.add(leftNamePanel);	
		leftNamePanel.setVisible(true);
		window.setVisible(true);
	}
	public void rightChange(int rightNum) {
		rightNamePanel = new JPanel();
		rightNamePanel.setBounds(50, 900, 350, 300);
		rightNamePanel.setBackground(Color.white);
		
		rightNameLabel = new JLabel ("Závìsy : " + rightNum);
		rightNameLabel.setForeground(Color.black);
		rightNameLabel.setFont(rzFont);
		
		rightNamePanel.add(rightNameLabel);
		con.add(rightNamePanel);	
		rightNamePanel.setVisible(true);
		window.setVisible(true);
		//return rightChangeNum;
	}
	public void result(int result) {
		resultNamePanel = new JPanel();
		resultNamePanel.setBounds(200, 500, 1300, 1000);
		resultNamePanel.setBackground(Color.white);
		
		resultNameLabel = new JLabel ("Výsledek = " + result);
		resultNameLabel.setForeground(Color.black);
		resultNameLabel.setFont(resultFont);
		
		resultNamePanel.add(resultNameLabel);
		con.add(resultNamePanel);	
		resultNamePanel.setVisible(true);	
		window.setVisible(true);
	}
}