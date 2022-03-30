package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class pelotarebota implements Screen {
    SpriteBatch sprite;
    Circle posicion;
    Vector2 velocidad;
    Texture texturapelota;
    OrthographicCamera camera;
    final pelota game;

    public pelotarebota(pelota game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, pelota.WIDTH, pelota.HEIGHT);
        sprite = new SpriteBatch();
        Pixmap ball = new Pixmap(Gdx.files.internal("pokeball.png"));
        Pixmap ballDim = new Pixmap(50, 50, ball.getFormat());
        ballDim.drawPixmap(ball, 0, 0, ball.getWidth(), ball.getHeight(), 0, 0, ballDim.getWidth(), ballDim.getHeight());
        texturapelota = new Texture(ballDim);
        posicion = new Circle(new Random().nextInt(Gdx.graphics.getWidth() - 212), new Random().nextInt(Gdx.graphics.getHeight() - 270), 25);
        velocidad = new Vector2(10f, 10f);
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 234, 86, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        if (posicion.x > Gdx.graphics.getWidth() - posicion.radius * 2 || posicion.x < 0) {
            velocidad.x = -velocidad.x;
        }
        if (posicion.y > Gdx.graphics.getHeight() - posicion.radius * 2 || posicion.y < 0) {
            velocidad.y = -velocidad.y;
        }

        posicion.x += velocidad.x;
        posicion.y += velocidad.y;

        sprite.begin();
        sprite.draw(new Texture(Gdx.files.internal("test.jpg")), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sprite.draw(texturapelota, posicion.x, posicion.y);
        sprite.end();
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                game.setScreen(new pelotarebotagravedad(game));
                return true;
            }
        });
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
