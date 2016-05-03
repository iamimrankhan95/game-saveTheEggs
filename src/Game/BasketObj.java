package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class BasketObj extends JLabel implements KeyListener, ActionListener,MouseMotionListener {
	Icon basketImage;
	int x=0,y=780;
	public BasketObj() {
		//this.setOpaque(false);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		//addMouseMotionListener(this);
		this.putPic();
	}

	private void putPic() {
		 basketImage=new ImageIcon("basketx.png");// label icon dite hoy not bufferedimage
		this.setIcon(basketImage);
		BackgroundPanel.sizeBasket = this.getPreferredSize() ;
//			size = this.getPreferredSize() ;
//			busketLabel.setBounds(0, 0, size.width, size.height);	
	}
	public void keyPressed(KeyEvent e)
	{
		int c=e.getKeyCode();
		
		if(c==KeyEvent.VK_LEFT)
		{	
			this.setLocation((x=x-20),y);	
		}
		
		if(c==KeyEvent.VK_RIGHT)
		{
			this.setLocation((x=x+20),y);
		}

	}
	public void keyTyped(KeyEvent e ){

	}
	public void keyReleased(KeyEvent e){

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
	
	//		this.setLocation(x=arg0.getX() ,y);	
		
//		if(c==KeyEvent.VK_RIGHT)
//		{
//			this.setLocation((x=x+20),y);
//		}
//		
	}

}
