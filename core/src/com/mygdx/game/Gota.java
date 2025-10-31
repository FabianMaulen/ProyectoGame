package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public interface Gota {

    void actualizar(float delta);

    void dibujar(SpriteBatch batch);

    Rectangle getArea();

    boolean estaFueraDePantalla();

    boolean alColisionar(Tarro tarro);
}