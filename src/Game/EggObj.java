package Game;

import java.awt.Dimension;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class EggObj extends JLabel{
	Icon whiteEggImage=new ImageIcon("whiteEggx.png");
	Icon goldenEggImage=new ImageIcon("goldenEgg.png");
	Random randEgg=new Random();int alter;
	int x=0,y=0;
	boolean descend=false;
	public EggObj() {
		this.setOpaque(false);
		this.putPic();
		//this.setVisible(true);
	}
	private void putPic() {
		alter=randEgg.nextInt(3);
		if(alter==1){
			this.setIcon(goldenEggImage);
			BackgroundPanel.sizeEgggldn=this.getPreferredSize();
		}
		else{
			this.setIcon(whiteEggImage);
			BackgroundPanel.sizeEggwhite=this.getPreferredSize();
		}
		
		
	}
	
	public void setDescend(boolean t, int xx, int yy)
	{
		this.descend = t ;
		this.x = xx ;
		this.y = yy ;
	}
	public boolean isDescend() {
		return descend;
	}
	public void animateEgg()
	{
		if(this.getIcon().equals(goldenEggImage)){
		this.setBounds(x, y+=15, BackgroundPanel.sizeEgggldn.width, BackgroundPanel .sizeEgggldn.height );
		}else{
			this.setBounds(x, y+=15, BackgroundPanel.sizeEggwhite.width, BackgroundPanel .sizeEggwhite.height );
		}
		
		if(y >= 780)
		{
			if((BackgroundPanel .bskt.x<=this.x) &&(this.x<=BackgroundPanel.bskt.x+100)){
				if(this.getIcon().equals(goldenEggImage)){
					BackgroundPanel.point+=10;
					BackgroundPanel.scoreBoardField.setText(String.valueOf(BackgroundPanel.point));
				}
				else{
					BackgroundPanel.point+=2;
					BackgroundPanel.scoreBoardField.setText(String.valueOf(BackgroundPanel.point));
				}
				
			}
			this.setVisible(false);
			this.setDescend(false, 0, 0);
		}
	}
}
