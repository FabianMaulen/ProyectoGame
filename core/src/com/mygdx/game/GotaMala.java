package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class GotaMala extends GotaAbstracta {

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
        movimiento.mover(area, delta);
    }

    @Override
    protected void aplicarEfecto(Tarro tarro) {
        boolean juegoContinua = !GameSessionManager.getInstance().perderVida();

        if (juegoContinua) {
            tarro.dañar();
        }
    }

    @Override
    public void dibujar(SpriteBatch batch) {
        batch.draw(textura, area.x, area.y, 96, 96);
    }

    @Override
    public Rectangle getArea() {
        return area;
    }

    @Override
    public boolean estaFueraDePantalla() {
        return area.y + area.height < 0;
    }
}