package Game;

public class FallingEggAnimation extends Thread{
BackgroundPanel tempPanelForFallingEgg;
	public FallingEggAnimation() {
		
	}
	public FallingEggAnimation(BackgroundPanel backgroundPanel) {
		tempPanelForFallingEgg=backgroundPanel;
	}
	public void run() { 
		int i=0;
		while(true){
			//System.out.println("falling egg");
			if(tempPanelForFallingEgg.egg[i].descend==true){
				tempPanelForFallingEgg.egg[i].animateEgg() ; 	
			}
			i++;
			if(i==tempPanelForFallingEgg.egg.length){
				i=0;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
