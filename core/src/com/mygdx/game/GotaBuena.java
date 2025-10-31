package com.mygdx.game;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class GotaBuena implements Gota {

    private Texture textura;
    private Rectangle area;
    private Sound dropSound;

    public GotaBuena(Texture textura, Sound dropSound, float x) {
        this.textura = textura;
        this.dropSound = dropSound;
        this.area = new Rectangle(x, 480, 64, 64);
    }

    @Override
    public void actualizar(float delta) {
        area.y -= 300 * delta;
    }

    @Override
    public void dibujar(SpriteBatch batch) {
        batch.draw(textura, area.x, area.y);
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
        tarro.sumarPuntos(10);
        dropSound.play();
        return true;
    }
}