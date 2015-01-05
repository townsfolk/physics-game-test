package com.teammochi.games.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.teammochi.games.PhysicsGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Physics Test Game!";
		config.width = 480; //(int) (PhysicsGame.MIN_WORLD_WIDTH_METERS * PhysicsGame.PIXELS_PER_METER);
		config.height = 800; //(int) (PhysicsGame.MIN_WORLD_HEIGHT_METERS * PhysicsGame.PIXELS_PER_METER);
		new LwjglApplication(new PhysicsGame(), config);
	}
}
