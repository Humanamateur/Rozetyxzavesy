package Rozetyxzavesy;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Graphics implements MouseListener{
	JFrame window;
	Container con;
	JPanel leftNamePanel;
	JLabel leftNameLabel;
	JPanel rightNamePanel;
	JLabel rightNameLabel;
	JPanel resultNamePanel;
	JLabel resultNameLabel;
	JPanel tableNamePanel;
	JLabel tableNameLabel;
	JLabel logo;
	ImageIcon icon;
	Font rzFont; 
	Font resultFont;
	Font tableFont;
	File results;
	
	int leftNum;
	int rightNum;
	float result;
	Instant lastTimeRight;
	Instant lastTimeLeft;
	
	public Graphics(int width, int height) throws IOException {
		results = new File("vysledky.txt");
		lastTimeLeft = Instant.now();
		lastTimeRight = Instant.now();
		leftNum = 0;
		rightNum = 0;
		result = 0;
		rzFont = new Font("Arial" , Font.BOLD, 75); 
		resultFont = new Font("Arial" , Font.BOLD, 300);
		tableFont = new Font("Arial" , Font.BOLD, 20);
		
		window = new JFrame();
		window.setSize(width, height);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.white);
		//window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//window.setUndecorated(true);
		window.setLayout(null);
		con = window.getContentPane();
		window.addMouseListener(this);
		logo();
		leftNumLabel();
		rightNumLabel();
		resultLabel();
		tableLabel();
		window.setVisible(true);
	}

	
	public void logo() throws IOException {
	  logo = new JLabel();
	  BufferedImage img = ImageIO.read(new File("logo.jpg"));
	  ImageIcon icon = new ImageIcon(img);
	  logo = new JLabel(icon);
	  logo.setBounds(1150, 0, 1000,200); //x,y,size x , size y, x1920 / y1080
	  con.add(logo);
	}
	
	public void leftNumLabel() {	
		leftNamePanel = new JPanel();
		leftNamePanel.setBounds(50, 100, 600, 100); //x,y,size x , size y, x1920 / y1080
		leftNamePanel.setBackground(Color.white);
		leftNameLabel = new JLabel ("ZÁVÌSY : " + leftNum);
		leftNameLabel.setForeground(Color.black);
		leftNameLabel.setFont(rzFont);
		leftNamePanel.add(leftNameLabel);
		con.add(leftNamePanel);	
		leftNamePanel.setVisible(true);
	}
	public void rightNumLabel() {
		rightNamePanel = new JPanel();
		rightNamePanel.setBounds(50, 900, 600, 100); //x,y,size x , size y, x1920 / y1080
		rightNamePanel.setBackground(Color.white);
		rightNameLabel = new JLabel ("ROZETY : " + rightNum);
		rightNameLabel.setForeground(Color.black);
		rightNameLabel.setFont(rzFont);
		rightNamePanel.add(rightNameLabel);
		con.add(rightNamePanel);	
		rightNamePanel.setVisible(true);
	}
	public void resultLabel() {		
				
		String formattedResult = String.format("%.02f", result);
		resultNamePanel = new JPanel();
		resultNamePanel.setBounds(200, 400, 1500, 300); //x,y,size x , size y
		resultNamePanel.setBackground(Color.white);
		resultNameLabel = new JLabel (formattedResult + "%");
		resultNameLabel.setForeground(Color.black);
		resultNameLabel.setFont(resultFont);
		
		resultNamePanel.add(resultNameLabel);
		con.add(resultNamePanel);	
		resultNamePanel.setVisible(true);	
	}
	public void tableLabel() throws FileNotFoundException {
		tableNamePanel = new JPanel();
		tableNamePanel.setBounds(1150, 210, 800, 300); //x,y,size x , size y
		tableNamePanel.setBackground(Color.white);
		
		loadTableLabel();
		
		tableNameLabel.setForeground(Color.black);
		tableNameLabel.setFont(tableFont);
		tableNamePanel.add(tableNameLabel);
		con.add(tableNamePanel);
		tableNamePanel.setVisible(true);
		
		
	}
	private void loadTableLabel() throws FileNotFoundException {
		String tmpS = "<html>";
		Scanner sc = new Scanner(results);
		
		int i = 0;
		while(sc.hasNextLine() && i <= 5) {
			tmpS = tmpS + sc.nextLine() + "<br/>";
			i++;
		}
		tmpS = tmpS + "</html>";  
		tableNameLabel = new JLabel(tmpS, SwingConstants.CENTER);
		sc.close();
	}
	public void resultChange() {
		
		
		if (leftNum != 0) {	
			result = (float) rightNum / leftNum * 100;
			String formattedResult = String.format("%.02f", result);
			resultNameLabel.setText(formattedResult + "%");
			
		}
		if(result < 60.0 ) {
			window.getContentPane().setBackground(Color.red);
		}
		else {
			window.getContentPane().setBackground(Color.green);
		}
	}
	
	public void leftChange() {
		Instant tmpTime = Instant.now();
		
		if(Duration.between(lastTimeLeft, tmpTime).toMillis() > 2000) {
			leftNum++;
			leftNameLabel.setText("ZÁVÌSY : " + Integer.toString(leftNum));
			lastTimeLeft = tmpTime;
		}
		
	}
	
	public void rightChange() {
		Instant tmpTime = Instant.now();

		if(Duration.between(lastTimeRight, tmpTime).toMillis() > 2000) {
			rightNum++;
			rightNameLabel.setText("ROZETY : " + Integer.toString(rightNum));
			lastTimeRight = tmpTime;
		}
	}

	
	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			
			
			leftChange();
			resultChange();
		}
		else if (SwingUtilities.isRightMouseButton(e)) {
			
			rightChange();
			resultChange();
			}
		else if (SwingUtilities.isMiddleMouseButton(e)) {
			try {
				FileWriter fw = new FileWriter("vysledky.txt", true);
				String result = String.format("%s vykon: %f.02 %s \n",LocalDateTime.now().toString() , this.result, "%");
				fw.append(result);
				fw.close();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
			
			result = 0;
			leftNum = 0;
			rightNum = 0;
			leftNameLabel.setText("ZÁVÌSY : " + Integer.toString(leftNum));
			rightNameLabel.setText("ROZETY : " + Integer.toString(rightNum));
			resultNameLabel.setText(Float.toString(result));
			}

	}
		
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}