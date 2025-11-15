package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;

public class MovimientoZigZag implements MovimientoStrategy {

    private boolean derecha = true;
    @Override
    public void mover(Rectangle area, float delta) {
        area.y -= 200 * delta;
        if (derecha) {
            area.x += 80 * delta;
        } else {
            area.x -= 80 * delta;
        }
        // cambia dirección aleatoriamente
        if (Math.random() < 0.02) {
            derecha = !derecha;
        }
    }
}
