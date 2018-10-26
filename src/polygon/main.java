package polygon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;



public class main{
	public static void main(String[] args) {
		JFrame GUI = new JFrame();
		int nump = Integer.parseInt(JOptionPane.showInputDialog("number of points", "5"));
		GUI.setTitle("Lab 3-7");
		GUI.setSize(316, 339);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ColorPanel panel = new ColorPanel(nump);
		Container pane = GUI.getContentPane();
		pane.add(panel);
		GUI.setVisible(true);
		
	}
}