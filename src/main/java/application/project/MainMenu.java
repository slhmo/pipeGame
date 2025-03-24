package application.project;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class MainMenu {
    private final AnchorPane anchorPane;
    private int state;
    public MainMenu(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
        createLevelOneButton();
        createLevelTwoButton();
        createLevelThreeButton();
    }
    private void createLevelOneButton() {
        Label levelOneLabel = new Label("level 1");
        levelOneLabel.setLayoutX(960);
        levelOneLabel.setLayoutY(anchorPane.getLayoutY()/2);
        levelOneLabel.setStyle("-fx-background-color: blue; -fx-font-size: 24px; -fx-text-fill: red;");
        levelOneLabel.setOnMouseClicked(event -> {
            state = 1;
        });
        anchorPane.getChildren().add(levelOneLabel);
    }

    private void createLevelTwoButton() {
        Label levelTwoLabel = new Label("level 2");
        levelTwoLabel.setLayoutX(960);
        levelTwoLabel.setLayoutY(anchorPane.getLayoutY()/2+200);
        levelTwoLabel.setStyle("-fx-background-color: blue; -fx-font-size: 24px; -fx-text-fill: red;");
        levelTwoLabel.setOnMouseClicked(event -> {
            state = 2;
        });
        anchorPane.getChildren().add(levelTwoLabel);
    }

    private void createLevelThreeButton() {
        Label levelThreeLabel = new Label("level 3");
        levelThreeLabel.setLayoutX(960);
        levelThreeLabel.setLayoutY(anchorPane.getLayoutY()/2+400);
        levelThreeLabel.setStyle("-fx-background-color: blue; -fx-font-size: 24px; -fx-text-fill: red;");
        levelThreeLabel.setOnMouseClicked(event -> {
            state = 3;
        });
        anchorPane.getChildren().add(levelThreeLabel);
    }

    public int getState() {
        return state;
    }
}
