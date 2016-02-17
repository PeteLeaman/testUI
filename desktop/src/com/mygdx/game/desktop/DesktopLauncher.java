package com.mygdx.game.desktop;

import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.testui;

public class DesktopLauncher {
	public static void main (String[] arg) {
//		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
//		config.resizable = true;
//		config.width = 750;
//		config.height = 750;
//		new LwjglApplication(new testui(), config);

		DisplayMode displayMode = LwjglApplicationConfiguration.getDesktopDisplayMode();
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.setFromDisplayMode(displayMode);
		new LwjglApplication(new testui(config.width, config.height), config);
	}
}
