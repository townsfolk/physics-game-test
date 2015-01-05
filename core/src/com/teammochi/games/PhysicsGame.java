package com.teammochi.games;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class PhysicsGame extends Game {

	public static float PIXELS_PER_METER = 1;
	public static float MIN_WORLD_WIDTH_METERS = 480f;
	public static float MIN_WORLD_HEIGHT_METERS = 800f;
	public static float GRAVITY = 9.8f; // meters per s^2

	SpriteBatch batch;
	Sprite img;
	Viewport viewport;
	World world;

	@Override
	public void create() {
		// uncomment to break EVERYTHING
		toMeters();
		viewport = new ExtendViewport(MIN_WORLD_WIDTH_METERS, MIN_WORLD_HEIGHT_METERS);

		batch = new SpriteBatch();
		img = new Sprite(new Texture("badlogic.jpg")); // img is 256 x 256
		img.setOriginCenter();
		Box2D.init();
		world = new World(new Vector2(0, GRAVITY), false);
	}

	@Override
	public void render() {
		viewport.getCamera().update();
		batch.setProjectionMatrix(viewport.getCamera().combined);
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		img.draw(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.log("PhysicsGame", "Resize width: " + width + ", height: " + height);
		viewport.update((int) (width / PIXELS_PER_METER), (int) (height / PIXELS_PER_METER), true);
		Gdx.app.log("PhysicsGame", "world width: " + viewport.getWorldWidth() + ", height: " + viewport.getWorldHeight());
		img.setPosition( // center sprite
				(viewport.getWorldWidth() - img.getWidth()) / 2,
				(viewport.getWorldHeight() - img.getHeight()) / 2
		);
		Gdx.app.log("PhysicsGame", "sprite x: " + img.getX() + ", y: " + img.getY() + ", width: " + img.getWidth() + ", height: " + img.getHeight() + ", scale: " + img.getScaleX());
		super.resize(width, height);
	}

	private void toMeters() {
		PIXELS_PER_METER = 100; // 100 pixels per meter
		MIN_WORLD_WIDTH_METERS = 4.80f; // should be equal to 480 pixels
		MIN_WORLD_HEIGHT_METERS = 8.00f; // should be equal to 800 pixels
	}
}
