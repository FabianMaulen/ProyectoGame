package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;

public class MovimientoAcelerado implements MovimientoStrategy {
    private float velocidad = 100;

    @Override
    public void mover(Rectangle area, float delta) {
        velocidad += 20 * delta;
        area.y -= velocidad * delta;

    }
}
