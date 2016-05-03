package Game;

import java.util.Random;

public class BirdMovingAnimation extends Thread{
	BackgroundPanel tempPanelForBird;
	public BirdMovingAnimation(BackgroundPanel backgroundPanel) {
		tempPanelForBird=backgroundPanel;
	}

//	protected BirdMovingAnimation1(BackgroundPanel x) {
//		// TODO Auto-generated constructor stub
//	}

	public void run() {
		boolean animator = true ;
		int i=0, k=0 ;
		Random random = new Random() ;
		
		while(animator)
		{
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					System.out.println("exception generated in bird.animate");
				}
				
				animator = this.tempPanelForBird.brd[i].animate();
				i++ ;
				
				if(i==5)
					i=0 ;
	
				if(animator == false)
					break ;		
		
		}
	}

}
