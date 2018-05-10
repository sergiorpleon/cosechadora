package cu.juego.implementacion;

import cu.juego.implementacion.Graficos.PixmapFormat;

public interface Pixmap {
	public int getWidth();
	
	public int getHeight();
	
	public PixmapFormat getFormat(); 
	
	public void dispose();
}
