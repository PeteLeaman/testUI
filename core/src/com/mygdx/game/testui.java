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
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class testui extends ApplicationAdapter implements InputProcessor {
	private Stage stage;
	private Skin skin;
	private Table table;
	private SpriteBatch batch;
	private Sprite sprite;

	private String questTitle = "Urgent Repairs Needed in Isle 5";
	private String questDescription = "After your ship was attacked by pirates, you crash landed on the planet Krakon. Several of your systems were critically damaged in the crash, making the ship unflyable. You will need to find the right parts to repair it and get it working again. Thank the stars you landed near the recently opened Plume Outpost (and not the recently destroyed Blume Outpost 20 miles east of it)";

	@Override
	public void create() {
		// setting up skin & stage
		skin = new Skin(Gdx.files.internal("uiskin.json"));
		stage = new Stage(new ScreenViewport());

		// setting up main UI table
		table = new Table();
		table.setWidth(stage.getWidth());
		table.align(Align.center | Align.top);
		table.setPosition(0, Gdx.graphics.getHeight());

		final QuestBox questContainer = new QuestBox(questTitle, questDescription, skin);
//
//		// setting up quest UI
//		final QuestBoxSimp questBoxSimp = new QuestBoxSimp("Urgent Repairs Needed in Isle 5", skin);
//
//		final TextButton acceptButton = new TextButton("Accept", skin, "default");
//		final TextButton declineButton = new TextButton("Decline", skin, "default");
//
//		// the label for the quest description
//		final Label questText = new Label("quest description", skin);
//		questText.setText("After your ship was attacked by pirates, you crash landed on the planet Krakon. Several of your systems were critically damaged in the crash, making the ship unflyable. You will need to find the right parts to repair it and get it working again. Thank the stars you landed near the recently opened Plume Outpost (and not the recently destroyed Blume Outpost 20 miles east of it)");
//		questText.setWrap(true);
//
//		// put quest description into a scroll pane so you can scroll down if too big
//		ScrollPane questTextScroll = new ScrollPane(questText, skin);
//
//		// put quest box inside a container so we can resize it easier
//		questContainer = new Container(questBoxSimp);
//		questContainer.size(250, 350);
//
//		// add the description and buttons to the quest box
//		questBoxSimp.getContentTable().add(questTextScroll).size(questContainer.getMaxWidth() - 20, questContainer.getMaxHeight() - 100); // use the table cell to change size of label
//		questBoxSimp.getButtonTable().add(acceptButton).size(100, 40);
//		questBoxSimp.getButtonTable().add(declineButton).size(100, 40);
//		questBoxSimp.getButtonTable().padBottom(10);
//
//		// alignment control for label
//		questText.setAlignment(Align.topLeft);
//
//		// alignment control for button (temp)
//		questBoxSimp.getButtonTable().getCell(acceptButton).padRight(10);
//		questBoxSimp.getButtonTable().getCell(declineButton).padLeft(10);
//
//		// how the decline and accept buttons on the quest box respond
//		acceptButton.addListener(new ClickListener() {
//									 @Override
//									 public void clicked(InputEvent event, float x, float y) {
//										 System.out.println("label width: " + questText.getWidth());
//									 }
//								 }
//		);
//		declineButton.addListener(new ClickListener() {
//									  @Override
//									  public void clicked(InputEvent event, float x, float y) {
//
//									  }
//								  }
//		);

		// test button for now to bring up the questbox
		final TextButton testButton = new TextButton("NPC offering Quest", skin, "default");
		testButton.addListener(new ClickListener() {
								   @Override
								   public void clicked(InputEvent event, float x, float y) {
									   table.add(questContainer);

								   }
							   }
		);

		// adding all main UI elements to table
		table.add(testButton).padTop(30).padBottom(3);

		// adding main UI table to stage
		stage.addActor(table);

		// background sprite stuff
		batch = new SpriteBatch();
		sprite = new Sprite(new Texture(Gdx.files.internal("core\\assets\\showcase.psd")));
		sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		// input stuff
		InputMultiplexer im = new InputMultiplexer(stage,this); // takes both and treats as one input processor, order passed in = order events handled (stage first, UI first)
		Gdx.input.setInputProcessor(im);
	}
//test
	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		sprite.draw(batch);
		batch.end();

		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
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
		return false; // false if you want the event to be continued, e.g. you want both the UI and base layer to handle it
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
