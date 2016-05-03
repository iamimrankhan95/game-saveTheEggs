package Game;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameFrame extends JFrame{

	BackgroundPanel background;
	
	public GameFrame() {
		this.setTitle("save the eggs!!");
		this.setSize(1500, 1000);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.initiate() ;
		this.addComponent() ;
		this.setVisible(true);
		//animateBird();
		//this.setLayout(new LayoutManager(3,1));
		this.setLayout(null);
	}
	private void addComponent() {
		this.add(background);
	}
	private void initiate() {
		background=new BackgroundPanel();
	}
	
}
