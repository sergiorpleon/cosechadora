package cu.juego.implementacion.cosechadora;

import java.util.List;


import cu.juego.implementacion.Graficos;
import cu.juego.implementacion.Juego;
import cu.juego.implementacion.Pantalla;
import cu.juego.implementacion.Input.TouchEvent;

public class PantallaAyuda3 extends Pantalla {
	public PantallaAyuda3(Juego juego) {
		super(juego);
		Control.autor =true;
	}

	@Override
	public void update(float deltaTime) {
		Graficos g = juego.getGraficos();
		List<TouchEvent> touchEvents = juego.getInput().getTouchEvents();
		juego.getInput().getkeyEvents();
		if (Control.isback) {
			synchronized (this) {
				Control.isback = false;
			}
			juego.setScreen(new MainMenuScreen(juego));
			if (Configuraciones.soundEnabled) {
				Assets.clic.play(1);
			}
		} else {
			int len = touchEvents.size();
			for (int i = 0; i < len; i++) {
				TouchEvent event = touchEvents.get(i);
				if (event.type == TouchEvent.TOUCH_UP) {
					//if (event.x > 256 && event.y > 416) {
					if (event.x > 236 && event.y > 400) {
						juego.setScreen(new MainMenuScreen(juego));
						if (Configuraciones.soundEnabled) {
							Assets.clic.play(1);
						}
					}
					if (event.x > 20 && event.x < 196) {
						if (event.y > 436 && event.y < 464) {
							Control.autor = !Control.autor;

						}
					}
				}

			}
		}
	}

	@Override
	public void present(float deltaTime) {
		// TODO Auto-generated method stub
		Graficos g = juego.getGraficos();
		g.drawPixmap(Assets.fondo, 0, 0);
		// g.drawPixmap(Assets.ayuda3, 64, 100);
		//g.drawPixmap(Assets.ayuda3, 9, 0);
		
		if (Control.autor) {
			//g.drawPixmap(Assets.logotren, 20, 436);
		} else {
			//g.drawPixmap(Assets.autor, 20, 436);

		}
		//g.drawPixmap(Assets.botones, 240, 400, 0, 128, 64, 64);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		Configuraciones.saved(juego.getFileIO());
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}
}
