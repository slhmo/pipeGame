package application.project;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class MainMenu {
    private final AnchorPane anchorPane;
    private int state;
    private static String gameResultText = "welcome";

    public MainMenu(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
        createLevelOneButton();
        createLevelTwoButton();
        createLevelThreeButton();
        createLevelCustomButton();
        generateGameResult();
        System.out.println(gameResultText);
    }
    private void createLevelOneButton() {
        Label levelOneLabel = new Label("level 1");
        levelOneLabel.setLayoutX(960);
        levelOneLabel.setLayoutY(300);
        levelOneLabel.setStyle("-fx-background-color: blue; -fx-font-size: 24px; -fx-text-fill: red;");
        levelOneLabel.setOnMouseClicked(event -> {
            state = 1;
        });
        anchorPane.getChildren().add(levelOneLabel);
    }

    private void createLevelTwoButton() {
        Label levelTwoLabel = new Label("level 2");
        levelTwoLabel.setLayoutX(960);
        levelTwoLabel.setLayoutY(500);
        levelTwoLabel.setStyle("-fx-background-color: blue; -fx-font-size: 24px; -fx-text-fill: red;");
        levelTwoLabel.setOnMouseClicked(event -> {
            state = 2;
        });
        anchorPane.getChildren().add(levelTwoLabel);
    }

    private void createLevelThreeButton() {
        Label levelThreeLabel = new Label("level 3");
        levelThreeLabel.setLayoutX(960);
        levelThreeLabel.setLayoutY(700);
        levelThreeLabel.setStyle("-fx-background-color: blue; -fx-font-size: 24px; -fx-text-fill: red;");
        levelThreeLabel.setOnMouseClicked(event -> {
            state = 3;
        });
        anchorPane.getChildren().add(levelThreeLabel);
    }
    private void createLevelCustomButton() {
        Label levelCustomLabel = new Label("level Custom");
        levelCustomLabel.setLayoutX(920);
        levelCustomLabel.setLayoutY(900);
        levelCustomLabel.setStyle("-fx-background-color: blue; -fx-font-size: 24px; -fx-text-fill: red;");
        levelCustomLabel.setOnMouseClicked(event -> {
            state = 4;
        });
        anchorPane.getChildren().add(levelCustomLabel);
    }

    public int getState() {
        return state;
    }

    private void generateGameResult() {
        Label gameResult = new Label("welcome");
        gameResult.setLayoutX(920);
        gameResult.setLayoutY(100);
        if (gameResultText.equals("welcome")) {
            gameResult.setStyle("-fx-background-color: gray; -fx-font-size: 34px; -fx-text-fill: black;");
        }
        else if(gameResultText.equals("you lost!")) {
            System.out.println("lost");
            gameResult.setText("you lost!");
            gameResult.setStyle("-fx-background-color: red; -fx-font-size: 34px; -fx-text-fill: black;");
        }
        else if (gameResultText.equals("you won!")) {
            System.out.println("won");
            gameResult.setText("you won!");
            gameResult.setStyle("-fx-background-color: green; -fx-font-size: 34px; -fx-text-fill: black;");
        }
        anchorPane.getChildren().add(gameResult);
    }

    public static void setResultLost() {
        gameResultText = "you lost!";
    }

    public static void setResultWon() {
        gameResultText = "you won!";
    }

}
