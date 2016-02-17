package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class testui extends ApplicationAdapter implements InputProcessor {
	private Stage stage;
	private Skin skin;
	private Table table;
	private SpriteBatch batch;
	private Sprite sprite;
	private int appHeight, appWidth;

	private String questTitle = "Urgent Repairs Needed in Isle 5";
	private String questDescription = "After your ship was attacked by pirates, you crash landed on the planet Krakon.\nSeveral of your systems were critically damaged in the crash, making the ship unflyable. You will need to find the right parts to repair it and get it working again.\nThank the stars you landed near the recently opened Plume Outpost (and not the recently destroyed Blume Outpost 20 miles east of it).";

	public testui(int appWidth, int appHeight) {
		super();
		this.appWidth = appWidth;
		this.appHeight = appHeight;
	}

	@Override
	public void create() {
		// setting up skin & stage
		skin = new Skin(Gdx.files.internal("uiskin.json"));
		stage = new Stage(new ScreenViewport()); // there are different types of viewports need to see which we need
		//stage = new Stage(new FitViewport(appWidth, appHeight));

		// setting up main UI table
		table = new Table();
		table.setWidth(stage.getWidth());
		//table.setHeight(stage.getHeight());
		table.align(Align.center | Align.top);
		table.setPosition(0, Gdx.graphics.getHeight());
		//table.setFillParent(true);

		final QuestBox testBox = new QuestBox(questTitle, questDescription, skin);

		// test button for now to bring up the questbox
		final TextButton testButton = new TextButton(" open quest box ", skin, "default");
		testButton.addListener(new ClickListener() {
								   @Override
								   public void clicked(InputEvent event, float x, float y) {
									   table.add(testBox);
									   System.out.println(testBox.getActor());
								   }
							   }
		);

		// exits the fullscreen so you can close window
		final TextButton exitButton = new TextButton(" go to windowed mode ", skin, "default");
		exitButton.addListener(new ClickListener() {
								   @Override
								   public void clicked(InputEvent event, float x, float y) {
									   Gdx.graphics.setWindowedMode(750, 750);
								   }
							   }
		);

		// adding all main UI elements to table
		table.add(testButton).padTop(200);
		table.add(exitButton).padTop(200).padLeft(100);

		// adding main UI table to stage
		stage.addActor(table);

		// background sprite stuff
		batch = new SpriteBatch();
		sprite = new Sprite(new Texture(Gdx.files.internal("assets/showcase.psd")));
		sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		// input stuff
		InputMultiplexer im = new InputMultiplexer(stage,this); // takes both and treats as one input processor, order passed in = order events handled (stage first, UI first)
		Gdx.input.setInputProcessor(im);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		sprite.draw(batch);
		batch.end();

		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}

	@Override
	public void resize (int width, int height) {
		stage.getViewport().update(width, height, true);
		table.setWidth(stage.getWidth());
		//table.setHeight(stage.getHeight());
	}


	/*
	due to it being an input processor all of these should be implemented
	these are what happens when input goes to the sprite batch, not the UI
	 */

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
