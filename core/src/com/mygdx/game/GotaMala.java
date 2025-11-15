package com.mygdx.game;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class GotaMala implements Gota {

    private Texture textura;
    private Rectangle area;
    private MovimientoStrategy movimiento;

    public GotaMala(Texture textura, float x, MovimientoStrategy movimientoInicial) {
        this.textura = textura;
        this.area = new Rectangle(x, 480, 64, 64);
        this.movimiento = movimientoInicial;
    }


    @Override
    public void actualizar(float delta) {
        area.y -= 300 * delta;
    }

    @Override
    public void dibujar(SpriteBatch batch) {
        batch.draw(textura, area.x, area.y,96,96);
    }

    @Override
    public Rectangle getArea() {
        return area;
    }

    @Override
    public boolean estaFueraDePantalla() {
        return area.y + area.height < 0;
    }

    @Override
    public boolean alColisionar(Tarro tarro) {
        tarro.dañar();
        return tarro.getVidas() > 0;
    }
}