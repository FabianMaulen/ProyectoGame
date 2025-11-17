package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameOverScreen extends PantallaBase {

    private SpriteBatch batch;
    private BitmapFont font;

    public GameOverScreen(final ProyectoGame juego) {
        super(juego);
        this.batch = juego.getBatch();
        this.font = juego.getFont();
    }

    @Override
    public void show() {
        // Puedes agregar lógica de sonido o animación si lo deseas
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        camara.update();
        batch.setProjectionMatrix(camara.combined);

        batch.begin();
        font.draw(batch, "GAME OVER", 100, 200);
        font.draw(batch, "Toca en cualquier lado para reiniciar.", 100, 100);
        batch.end();

        if (Gdx.input.isTouched()) {
            GameSessionManager.getInstance().ResetSession();
            juego.setScreen(new GameScreen(juego));
            dispose();
        }
    }
}
