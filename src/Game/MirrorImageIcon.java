package Game;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class MirrorImageIcon extends ImageIcon {

	public MirrorImageIcon() {
		// TODO Auto-generated constructor stub
	}
	public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
    	Graphics2D g2 = (Graphics2D)g.create();
    	g2.translate(getIconWidth(), 0);
    	g2.scale(-1, 1);
    	super.paintIcon(c, g2, x, y);
    }

	public MirrorImageIcon(String filename) {
		super(filename);
		// TODO Auto-generated constructor stub
	}

	public MirrorImageIcon(URL location) {
		super(location);
		// TODO Auto-generated constructor stub
	}

	public MirrorImageIcon(Image image) {
		super(image);
		// TODO Auto-generated constructor stub
	}

	public MirrorImageIcon(byte[] imageData) {
		super(imageData);
		// TODO Auto-generated constructor stub
	}

	public MirrorImageIcon(String filename, String description) {
		super(filename, description);
		// TODO Auto-generated constructor stub
	}

	public MirrorImageIcon(URL location, String description) {
		super(location, description);
		// TODO Auto-generated constructor stub
	}

	public MirrorImageIcon(Image image, String description) {
		super(image, description);
		// TODO Auto-generated constructor stub
	}

	public MirrorImageIcon(byte[] imageData, String description) {
		super(imageData, description);
		// TODO Auto-generated constructor stub
	}

}
