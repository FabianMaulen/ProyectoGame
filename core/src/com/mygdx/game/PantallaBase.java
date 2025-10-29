package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;

public abstract class PantallaBase implements Screen {
    protected ProyectoGame juego;
    protected OrthographicCamera camara;

    public PantallaBase(ProyectoGame juego) {
        this.juego = juego;
        camara = new OrthographicCamera();
        camara.setToOrtho(false, 800, 480);
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {}
}

