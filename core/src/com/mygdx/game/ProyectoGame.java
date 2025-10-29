package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ProyectoGame extends Game {

    private SpriteBatch batch;
    private BitmapFont font;
    private int higherScore = 0 ;

    @Override
    public void create() {
        try {
            batch = new SpriteBatch();
            font = new BitmapFont();
            this.setScreen(new MainMenuScreen(this));
        } catch (Exception e) {
            e.printStackTrace(); // mostrará el error real en consola
        }
    }


    public SpriteBatch getBatch() {
        return batch;
    }

    public BitmapFont getFont() {
        return font;
    }

    public int getHigherScore() {
        return higherScore;
    }

    public void setHigherScore(int score) {
        this.higherScore = score;
    }


    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
        super.dispose();
    }
}
