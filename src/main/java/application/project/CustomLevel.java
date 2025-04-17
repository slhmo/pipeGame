package application.project;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;


public class CustomLevel{
    int maxMoves;
    int [][] solution;
    boolean saved;

    public CustomLevel(AnchorPane anchorPane) {
        Label label = new Label("Enter inputs");
        label.setLayoutX(200);
        label.setLayoutY(200);
        label.setStyle("-fx-background-color: blue; -fx-font-size: 24px; -fx-text-fill: red;");

        TextField mapTextField = new TextField("Enter map here...");
        mapTextField.setLayoutX(200);
        mapTextField.setLayoutY(400);

        TextField maxMovesTextField = new TextField("Enter maxMoves here...");
        maxMovesTextField.setLayoutX(200);
        maxMovesTextField.setLayoutY(600);

        Label saveButtonLabel = new Label("save");
        saveButtonLabel.setLayoutX(200);
        saveButtonLabel.setLayoutY(800);
        saveButtonLabel.setStyle("-fx-background-color: blue; -fx-font-size: 24px; -fx-text-fill: red;");


        saveButtonLabel.setOnMouseClicked(event -> {
            String input = mapTextField.getText();
            parseMap(input);
            maxMoves = Integer.parseInt(maxMovesTextField.getText());
            System.out.println("here" + input + maxMoves);
            anchorPane.getChildren().remove(label);
            anchorPane.getChildren().remove(mapTextField);
            anchorPane.getChildren().remove(maxMovesTextField);
            anchorPane.getChildren().remove(saveButtonLabel);
            saved = true;
        });

        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(mapTextField);
        anchorPane.getChildren().add(maxMovesTextField);
        anchorPane.getChildren().add(saveButtonLabel);
//        int [][] solution =
    }

    private void parseMap(String input) {
        input = input.substring(1, (input.length()-1));
        String[] inputSplit = input.split("[{\\, \\}]");
        ArrayList<Integer> inputIntegers = new ArrayList<>();
        for (String temp : inputSplit) {
            if (!temp.equals("")) {
                inputIntegers.add(Integer.parseInt(temp));
            }
        }
        int mapSize = (int) Math.sqrt(inputIntegers.size());
        solution = new int[mapSize][mapSize];
        for (int row = 0; row<mapSize; row++) {
            for (int column = 0; column<mapSize; column++) {
                solution[row][column] = inputIntegers.get(row * mapSize + column);
                System.out.print(+solution[row][column]);
            }
            System.out.println("\t");
        }
    }

    public int getMaxMoves() {
        return maxMoves;
    }

    public int[][] getSolution() {
        return solution;
    }

    public boolean isSaved() {
        return saved;
    }
}
