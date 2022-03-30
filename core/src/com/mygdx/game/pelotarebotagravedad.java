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

public class pelotarebotagravedad implements Screen {
	SpriteBatch sprite;
	Circle position;
	Vector2 velocidad, gravity;
	Texture texturapelota;
	OrthographicCamera camera;
	final pelota game;

	public pelotarebotagravedad(pelota game){
		this.game = game;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, pelota.WIDTH, pelota.HEIGHT);
		sprite = new SpriteBatch();
		Pixmap ball = new Pixmap(Gdx.files.internal("pokeball.png"));
		Pixmap ballDim = new Pixmap(50, 50, ball.getFormat());
		ballDim.drawPixmap(ball, 0, 0, ball.getWidth(), ball.getHeight(), 0, 0, ballDim.getWidth(), ballDim.getHeight());
		texturapelota = new Texture(ballDim);
		position = new Circle(10,  20, 25);
		velocidad = new Vector2(5f, 25f);
	}



	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 234, 86, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (position.x > Gdx.graphics.getWidth() - position.radius*2 || position.x < 0)	velocidad.x = -velocidad.x;
		if (position.y > Gdx.graphics.getHeight() - position.radius*2 || position.y < 0) velocidad.y = - velocidad.y;
		velocidad.y = velocidad.y - 1;
		if(position.y < 0) velocidad.y = 25f;

		position.set(position.x + velocidad.x, position.y + velocidad.y, 25);
		sprite.begin();
		sprite.draw(new Texture(Gdx.files.internal("test.jpg")), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		sprite.draw(texturapelota, position.x , position.y );
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
