package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;

public class MovimientoVertical implements MovimientoStrategy{

    @Override
    public void mover(com.badlogic.gdx.math.Rectangle area, float delta) {
        area.y -= 200 * delta;

    }
}

