package Game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BackgroundPanel extends JPanel implements KeyListener,MouseMotionListener{
	BufferedImage  backgroundImage;
	static Dimension sizeBasket,sizeBird,sizeEgggldn,sizeEggwhite;
	static BasketObj bskt;
	 BirdObj[] brd =new BirdObj[5];		
	 EggObj[] egg = new EggObj[20] ;
	 JLabel scoreBoard;static JLabel scoreBoardField;
	 static int point;
	private EggObj eggex;
	public BackgroundPanel() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		this.setSize(1500, 1000);
		this.setBackgroundImage();
		this.initial();
		this.setLayout(null);
		this.addcomponent();
		this.addMouseMotionListener(this);
	}
	private void addcomponent() {
		
		
		this.add(scoreBoard);
		this.add(scoreBoardField);
		
		bskt.setBounds(0, 780, sizeBasket.width, sizeBasket.height);	
		this.add(bskt);
					
			for(int i=0; i<brd.length; i++)
			{				
				this.brd[i].setBounds(brd[i].getX(), brd[i].getY(), sizeBird.width, sizeBird.height);
				this.add(brd[i]) ;
			}
			BirdMovingAnimation moveBird=new BirdMovingAnimation(this);
			moveBird.start();

			LayingEggAnimation layEgg=new LayingEggAnimation(this);
			layEgg.start();
			
			FallingEggAnimation falling=new FallingEggAnimation(this);
			falling.start();

	}
	private void setBasket() {
		
	}
	private void initial() {
		scoreBoard=new JLabel("Score: ");
		scoreBoardField=new JLabel("0");
		this.scoreBoard.setBounds(0,0,100,40);this.scoreBoard.setVisible(true);
		scoreBoardField.setBounds(120,0,100,40);scoreBoardField.setVisible(true);
		bskt=new BasketObj();
		for(int i=0;i<brd.length;i++){
			BirdObj b = new BirdObj() ;
			int x = BirdObj.getRandomX() ;
			b.setX(x);
			int y = BirdObj.getRandomY() ;
			b.setY(y);
			this.brd[i] = b ;
		}
		
		
		for(int i=0;i<20;i++){
			eggex=new EggObj();
			egg[i]=eggex;
			
		}
		
	}
	private void setBackgroundImage() {
		try {
			backgroundImage = ImageIO.read(new File("field.png")) ;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0,0, 1500,1000,null) ;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		bskt.setBounds(bskt.x=e.getX(), 780, sizeBasket.width, sizeBasket.height);	
		this.add(bskt);
		
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
int c=arg0.getKeyCode();
		
		if(c==KeyEvent.VK_LEFT)
		{	
			bskt.setLocation((bskt.x=bskt.x-20),bskt.y);	
		}
		
		if(c==KeyEvent.VK_RIGHT)
		{
			bskt.setLocation((bskt.x=bskt.x+20),bskt.y);
		}
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
