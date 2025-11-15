package com.mygdx.game;

public class GameSessionManager {
    private static final GameSessionManager INSTANCE = new GameSessionManager();
    private int puntos;
    private int vidas;

    private GameSessionManager() {
        this.puntos = 0;
        this.vidas = 3;
    }

    public static GameSessionManager getInstance() {
        return INSTANCE;
    }

    public void sumaPuntos(int puntos) {
        this.puntos += puntos;
    }

    public boolean perderVida() {
        this.vidas--;
        return this.vidas <= 0;
    }

    public int getPuntos() { return puntos; }
    public int getVidas() { return vidas; }

    public void ResetSession() {
        this.puntos = 0;
        this.vidas = 3;
    }
}