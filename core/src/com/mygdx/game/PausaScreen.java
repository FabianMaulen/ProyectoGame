package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
public class PausaScreen extends PantallaBase {

    private GameScreen juegoAnterior;
    private SpriteBatch batch;
    private BitmapFont font;

    public PausaScreen(final ProyectoGame juego, GameScreen juegoAnterior) {
        super(juego);
        this.juegoAnterior = juegoAnterior;
        this.batch = juego.getBatch();
        this.font = juego.getFont();
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 1.0f, 0.5f);
        camara.update();
        batch.setProjectionMatrix(camara.combined);

        batch.begin();
        font.draw(batch, "Juego en Pausa", 100, 150);
        font.draw(batch, "Toca en cualquier lado para continuar !!!", 100, 100);
        batch.end();

        if (Gdx.input.isTouched()) {
            juego.setScreen(juegoAnterior);
            dispose();
        }
    }
}
