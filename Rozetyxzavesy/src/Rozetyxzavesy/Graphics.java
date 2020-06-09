package Rozetyxzavesy;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;
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
	JLabel logo;
	ImageIcon icon;
	Font rzFont = new Font("Arial" , Font.BOLD, 75); 
	Font resultFont = new Font("Arial" , Font.BOLD, 300);
	
	public void window(float result) {
		window = new JFrame();
		window.setSize(1920, 1080);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.white);
		//window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//window.setUndecorated(true);
		window.setLayout(null);
		con = window.getContentPane();
		//window.setVisible(true);
	}
	
	public void logo() {
	  logo = new JLabel();
	  ImageIcon icon = new ImageIcon("logo.jpg");
	  logo = new JLabel(icon);
	  logo.setBounds(1500, 300, 100, 82); //x,y,size x , size y
	  con.add(logo);
	}
	
	public void leftChange(float leftNum) {	
		leftNamePanel = new JPanel();
		leftNamePanel.setBounds(50, 100, 600, 100); //x,y,size x , size y
		leftNamePanel.setBackground(Color.white);
		leftNameLabel = new JLabel ("ZÁVÌSY : " + leftNum);
		leftNameLabel.setForeground(Color.black);
		leftNameLabel.setFont(rzFont);
		leftNamePanel.add(leftNameLabel);
		con.add(leftNamePanel);	
		leftNamePanel.setVisible(true);
		//window.setVisible(true);
	}
	public void rightChange(float rightNum) {
		rightNamePanel = new JPanel();
		rightNamePanel.setBounds(50, 900, 600, 100); //x,y,size x , size y
		rightNamePanel.setBackground(Color.white);
		rightNameLabel = new JLabel ("ROZETY : " + rightNum);
		rightNameLabel.setForeground(Color.black);
		rightNameLabel.setFont(rzFont);
		rightNamePanel.add(rightNameLabel);
		con.add(rightNamePanel);	
		rightNamePanel.setVisible(true);
		//window.setVisible(true);
		//return rightChangeNum;
	}
	public void result(float result) {
		String formattedResult = String.format("%.02f", result);
		resultNamePanel = new JPanel();
		resultNamePanel.setBounds(200, 400, 1500, 300); //x,y,size x , size y
		resultNamePanel.setBackground(Color.white);
		resultNameLabel = new JLabel (formattedResult + "%");
		resultNameLabel.setForeground(Color.black);
		resultNameLabel.setFont(resultFont);
		if(result < 60.0 ) {
			window.getContentPane().setBackground(Color.red);
		}
		else {
			window.getContentPane().setBackground(Color.green);
		}
		resultNamePanel.add(resultNameLabel);
		con.add(resultNamePanel);	
		resultNamePanel.setVisible(true);	
		//window.setVisible(true);
	}
	public void setVisible() {
	window.setVisible(true);
	}
	
}