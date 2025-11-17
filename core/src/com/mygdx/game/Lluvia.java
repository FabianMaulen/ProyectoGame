package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class Lluvia {
    private Array<Gota> gotas;
    private long lastDropTime;

    private Texture texturaGotaBuena;
    private Texture texturaGotaMala;
    private Sound dropSound;
    private Music rainMusic;

    public Lluvia(Texture gotaBuena, Texture gotaMala, Sound ss, Music mm) {
        rainMusic = mm;
        dropSound = ss;
        this.texturaGotaBuena = gotaBuena;
        this.texturaGotaMala = gotaMala;
    }

    public void crear() {
        gotas = new Array<Gota>();
        crearGotaDeLluvia();

        rainMusic.setLooping(true);
        rainMusic.play();
    }

    private void crearGotaDeLluvia() {
        float x = MathUtils.random(0, 800 - 64);

        // Elegimos una estrategia de movimiento aleatoria
        MovimientoStrategy estrategia;
        int tipo = MathUtils.random(0, 3); // 0 a 3 → cuatro tipos de movimiento
        switch (tipo) {
            case 0: estrategia = new MovimientoVertical(); break;
            case 1: estrategia = new MovimientoDiagonal(); break;
            case 2: estrategia = new MovimientoZigZag(); break;
            default: estrategia = new MovimientoAcelerado(); break;
        }

        if (MathUtils.random(1, 10) < 5) {
            // Gota mala (puedes modificarla ig ual que GotaBuena para usar Strategy)
            gotas.add(new GotaMala(texturaGotaMala, x, estrategia));
        } else {
            // Gota buena con estrategia
            gotas.add(new GotaBuena(texturaGotaBuena, dropSound, x, estrategia));
        }

        lastDropTime = TimeUtils.nanoTime();
    }

    public boolean actualizarMovimiento(Tarro tarro) {
        if (TimeUtils.nanoTime() - lastDropTime > 200000000) crearGotaDeLluvia();

        for (int i = gotas.size - 1; i >= 0; i--) {
            Gota gota = gotas.get(i);
            gota.actualizar(Gdx.graphics.getDeltaTime());

            if (gota.estaFueraDePantalla()) {
                gotas.removeIndex(i);
                continue;
            }

            if (gota.getArea().overlaps(tarro.getArea())) {
                boolean juegoContinua = gota.alColisionar(tarro);
                gotas.removeIndex(i);

                if (!juegoContinua) {
                    return false;
                }
            }
        }
        return true;
    }

    public void actualizarDibujoLluvia(SpriteBatch batch) {
        for (Gota gota : gotas) {
            gota.dibujar(batch);
        }
    }

    public void destruir() {
        dropSound.dispose();
        rainMusic.dispose();
    }

    public void pausar() {
        rainMusic.stop();
    }

    public void continuar() {
        rainMusic.play();
    }
}
