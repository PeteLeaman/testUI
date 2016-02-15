package com.mygdx.game;


import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

public class QuestBox extends Container {
    private Skin skin;
    private String questTitle, questDescription;
    private Dialog dialog;
    private ScrollPane scrollPane;
    private Label descriptionLabel;
    private TextButton acceptButton, declineButton;

    public QuestBox(String questTitle, String questDescription, Skin skin) {
        this.questTitle = questTitle;
        this.questDescription = questDescription;
        this.skin = skin;
        createBox();
    }

    public void createBox() {
        // set the quest box size
        size(250, 350);

        // create the dialog
        dialog = new Dialog(questTitle, skin);

        // create the buttons
        acceptButton = new TextButton("Accept", skin);
        declineButton = new TextButton("Decline", skin);

        // create the quest description label
        descriptionLabel = new Label("quest description", skin);
        descriptionLabel.setText(questDescription);
        descriptionLabel.setWrap(true);

        // create the scroll pane
        scrollPane = new ScrollPane(descriptionLabel, skin);

        // add the description label (in scroll pane) and buttons to the quest box
        dialog.getContentTable().add(scrollPane).size(getMaxWidth() - 20, getMaxHeight() - 100); // use the table cell to change size of label
        dialog.getButtonTable().add(acceptButton).size(100, 40);
        dialog.getButtonTable().add(declineButton).size(100, 40);
        dialog.getButtonTable().padBottom(10);

        // alignment control for label
        descriptionLabel.setAlignment(Align.topLeft);

        // alignment control for button (temp)
        dialog.getButtonTable().getCell(acceptButton).padRight(10);
        dialog.getButtonTable().getCell(declineButton).padLeft(10);

        // how the decline and accept buttons on the quest box respond
        acceptButton.addListener(new ClickListener() {
                                     @Override
                                     public void clicked(InputEvent event, float x, float y) {

                                     }
                                 }
        );
        declineButton.addListener(new ClickListener() {
                                      @Override
                                      public void clicked(InputEvent event, float x, float y) {

                                      }
                                  }
        );


    }


}
