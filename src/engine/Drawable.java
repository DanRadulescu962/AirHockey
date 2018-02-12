package engine;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

public interface Drawable {

	public void accept(IDrawer d);
	
}
