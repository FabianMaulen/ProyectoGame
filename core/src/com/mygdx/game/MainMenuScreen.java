package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;


public class MainMenuScreen extends PantallaBase {

	private SpriteBatch batch;
	private BitmapFont font;


    public MainMenuScreen(ProyectoGame juego) {
        super(juego);
        this.batch = juego.getBatch();
        this.font = juego.getFont();
    }

    @Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);

		camara.update();
		batch.setProjectionMatrix(camara.combined);

		batch.begin();
		font.getData().setScale(2, 2);
		font.draw(batch, "Bienvenido a Recolecta Gotas!!! ", 100, camara.viewportHeight/2+50);
		font.draw(batch, "Toca en cualquier lugar para comenzar!", 100, camara.viewportHeight/2-50);

		batch.end();

		if (Gdx.input.isTouched()) {
			juego.setScreen(new GameScreen(juego));
			dispose();
		}
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
