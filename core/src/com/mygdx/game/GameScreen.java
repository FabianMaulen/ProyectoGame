package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen extends PantallaBase {

    private SpriteBatch batch;
    private BitmapFont font;
    private Tarro tarro;
    private Lluvia lluvia;

    public GameScreen(final ProyectoGame juego) {
        super(juego);
        this.batch = juego.getBatch();
        this.font = juego.getFont();

        Sound hurtSound = Gdx.audio.newSound(Gdx.files.internal("hurt.ogg"));
        tarro = new Tarro(new Texture(Gdx.files.internal("bucket.png")), hurtSound);

        Texture gota = new Texture(Gdx.files.internal("drop.png"));
        Texture gotaMala = new Texture(Gdx.files.internal("dropBad.png"));
        Sound dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
        Music rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
        lluvia = new Lluvia(gota, gotaMala, dropSound, rainMusic);

        tarro.crear();
        lluvia.crear();
    }

    @Override
    public void show() {
        lluvia.continuar();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        camara.update();
        batch.setProjectionMatrix(camara.combined);

        batch.begin();
        font.draw(batch, "Gotas totales: " + GameSessionManager.getInstance().getPuntos(), 5, 475);
        font.draw(batch, "Vidas : " + tarro.getVidas(), 670, 475);
        font.draw(batch, "HighScore : " + juego.getHigherScore(), camara.viewportWidth / 2 - 50, 475);

        if (!tarro.estaHerido()) {
            tarro.actualizarMovimiento();
            if (!lluvia.actualizarMovimiento(tarro)) {
                if (juego.getHigherScore() < GameSessionManager.getInstance().getPuntos())
                    juego.setHigherScore(GameSessionManager.getInstance().getPuntos());
                juego.setScreen(new GameOverScreen(juego));
                dispose();
            }
        }

        tarro.dibujar(batch);
        lluvia.actualizarDibujoLluvia(batch);
        batch.end();
    }

    @Override
    public void pause() {
        lluvia.pausar();
        juego.setScreen(new PausaScreen(juego, this));
    }

    @Override
    public void dispose() {
        tarro.destruir();
        lluvia.destruir();
    }
}
