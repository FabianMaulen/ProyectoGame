package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class GotaAbstracta {

    public abstract void actualizar(float delta);
    public abstract void dibujar(SpriteBatch batch);
    public abstract Rectangle getArea();
    public abstract boolean estaFueraDePantalla();

    protected abstract void aplicarEfecto(Tarro tarro);

    public final boolean procesar(Tarro tarro) {
        if (getArea().overlaps(tarro.getArea())) {
            aplicarEfecto(tarro);
            return true;
        }

        if (estaFueraDePantalla()) {
            return true;
        }

        return false;
    }
}