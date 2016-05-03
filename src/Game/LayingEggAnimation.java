package Game;

import java.util.Random;

public class LayingEggAnimation extends Thread{
	boolean layEgg=true;
	static boolean laid=false;
	BackgroundPanel tempPanelForEgg;
	Random randbrd=new Random();Random randEgg=new Random();
	static int brdNo,eggNo;
	public LayingEggAnimation() {
		
	}
	public LayingEggAnimation(BackgroundPanel backgroundPanel) {
		tempPanelForEgg=backgroundPanel;
	}
	public void run() {
		int i=0;
		while(layEgg){
		
			brdNo=randbrd.nextInt(5);eggNo=randEgg.nextInt(20);
			if(tempPanelForEgg.egg[eggNo].descend==false){
				tempPanelForEgg.egg[eggNo].x=tempPanelForEgg.brd[brdNo].getX();
				tempPanelForEgg.egg[eggNo].y=tempPanelForEgg.brd[brdNo].getY();
				
				if(tempPanelForEgg.egg[eggNo].getIcon().equals(tempPanelForEgg.egg[eggNo].goldenEggImage)){
					if(tempPanelForEgg.brd[brdNo].getIcon().equals(BirdObj.birdImage)){
						tempPanelForEgg.egg[eggNo].setBounds((tempPanelForEgg.egg[eggNo].x+=25), (tempPanelForEgg.egg[eggNo].y+=(BackgroundPanel.sizeEgggldn.width-15)), BackgroundPanel.sizeEgggldn.width, BackgroundPanel.sizeEgggldn.height);
					}
					else{
						tempPanelForEgg.egg[eggNo].setBounds((tempPanelForEgg.egg[eggNo].x+=15), (tempPanelForEgg.egg[eggNo].y+=(BackgroundPanel.sizeEgggldn.width-15)), BackgroundPanel.sizeEgggldn.width, BackgroundPanel.sizeEgggldn.height);
					}
				}else{
					if(tempPanelForEgg.brd[brdNo].getIcon().equals(BirdObj.birdImage)){
						tempPanelForEgg.egg[eggNo].setBounds((tempPanelForEgg.egg[eggNo].x+=40), (tempPanelForEgg.egg[eggNo].y+=(BackgroundPanel.sizeEggwhite.width-15)), BackgroundPanel.sizeEggwhite.width, BackgroundPanel.sizeEggwhite.height);
					}
					else{
						tempPanelForEgg.egg[eggNo].setBounds((tempPanelForEgg.egg[eggNo].x+=15), (tempPanelForEgg.egg[eggNo].y+=(BackgroundPanel.sizeEggwhite.width-15)), BackgroundPanel.sizeEggwhite.width, BackgroundPanel.sizeEggwhite.height);
					}
				}
				
				
				
				tempPanelForEgg.add(tempPanelForEgg.egg[eggNo]);
				this.tempPanelForEgg.egg[eggNo].setVisible(true);
				System.out.println(eggNo);
				
				this.tempPanelForEgg.egg[eggNo].descend=true;
			}
			

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("exception generated in bird.animate");
			}
		}
	}
}
