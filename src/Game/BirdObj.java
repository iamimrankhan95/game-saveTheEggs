package Game;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BirdObj extends JLabel{
	AffineTransform tx ;Random randBrd=new Random();int alter;
	static ImageIcon birdImageMirror=new MirrorImageIcon("angry.gif");
	static ImageIcon  birdImage=new ImageIcon("angry.gif");// label icon dite hoy not bufferedimage
	boolean isAtEdge=false;
	private static int[] randomX = new int[5], randomY = new int[5] ; static int i=-1, j=-1 ;
	int x,y;
	public BirdObj() {
		this.putPic();
		generateRandomX();
		generateRandomY();
	
		this.setOpaque(false);
	}
	private void putPic() {
		alter=randBrd.nextInt(2);
		if(alter==1){
			
				//System.out.println("image bird");
			 this.setIcon(birdImage);
		}
		else{
			// it will filip at edge
			this.setIcon(birdImageMirror);
		}
	
		BackgroundPanel.sizeBird = this.getPreferredSize() ;
	}
	
	public static int generateRandomX() {
		Random rand = new Random() ;
		int value ;
		boolean similar ;boolean on=true;
		
		for(int i=0; i<randomX.length; i++)
			randomX[i] = -1 ;
		
		for(int i=0; i<randomX.length; i++)
		{
				similar = false ;
				value = rand.nextInt(700) ;
				
				for(int j=0; j<randomX.length; j++)
				{
					if(randomX[j] == value){
						similar = true ;
					}
				}
				
				if(similar == false){
					randomX[i] = value ;
					if(on==false){
						 randomX[i]=randomX[i]+100;				
					}
					 if(on==true){
						 on=false;
					 }else{
						 on=true;
					 }
				   
				}
					
				else{
					i-- ;
				}
				
		}
		return 0;
	}
	public static int generateRandomY() {
		Random rand = new Random() ;
		int value ;
		boolean similar;boolean on=true;
		
		for(int i=0; i<randomY.length; i++)
			randomY[i] = -1 ;
		
		for(int i=0; i<randomY.length; i++)
		{
			similar = false ;
			value = rand.nextInt(200) ;
			
			for(int j=0; j<randomY.length; j++)
			{
				if(randomY[j] == value)
					similar = true ;
			}
			
			if(similar == false){
				randomY[i] = value ;
				if(on==false){
					 randomY[i]=randomY[i]+50;					
				}
				 if(on==true){
					 on=false;
				 }else{
					 on=true;
				 }
			   
			}
			else{
				i-- ;
			}				
		}

		return 0;
	}
	public static int getRandomX()
	{
		return randomX[++i];
	}
	
	public static int getRandomY() 
	{
		int temp = randomY[++j]+1 ;
		return temp;
	}
	public void setX(int value)
	{
		this.x = value ;
	}
	public int getX()
	{
		return this.x ;
	}
	
	public void setY(int value)
	{
		this.y = value ;
	}
	public int getY()
	{
		return this.y ;
	}
	public boolean animate() 
	{
	
		if(this.isAtEdge == true){
			
							if(this.getIcon().equals(birdImageMirror)){
								this.setIcon(birdImage);
								//this.x+=15;
								this.setBounds(x+=25+randBrd.nextInt(5), y, BackgroundPanel.sizeBird.width, BackgroundPanel .sizeBird.height) ;
							}else {
								this.setIcon(birdImageMirror);
								//this.x-=15 ;
								this.setBounds(x-=(25+randBrd.nextInt(5)), y, BackgroundPanel.sizeBird.width, BackgroundPanel .sizeBird.height) ;
							}
							this.isAtEdge=false;
							//this.setBounds(x, y, BackgroundPanel.sizeBird.width, BackgroundPanel .sizeBird.height) ;
							return true;
				}
		
		else{
				if(this.getIcon().equals(birdImage)){
						//this.setIcon(birdImage);
						//this.x=this.x+ 15 ;
						this.setBounds(x+=10+randBrd.nextInt(5), y, BackgroundPanel.sizeBird.width, BackgroundPanel .sizeBird.height) ;
						if(this.x+15>=1400){
							this.isAtEdge = true ;
							}
					}else{
							//this.x-=15;
							this.setBounds(x-=(10+randBrd.nextInt(5)), y, BackgroundPanel.sizeBird.width, BackgroundPanel .sizeBird.height) ;
							if(this.x-15<=20){
								this.isAtEdge = true ;
							}
						
					}
				
		 }				
			
		return true;	
	}
}
