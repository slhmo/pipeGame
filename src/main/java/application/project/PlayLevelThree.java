package application.project;

import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;

public class PlayLevelThree extends PlayLevelTwo{
    private Label undoButton;
    private int numberOfUndo;
    private int numberOfAutoFill = 0;

    public PlayLevelThree(AnchorPane anchorPane, int[][] solution, int maxMoves) {
        super(anchorPane, solution, maxMoves);
        autoFill();
        this.undoButton = generateUndoButton();
    }

    private Label generateUndoButton() {
        this.undoButton = new Label();
        undoButton.setText("undo");
        undoButton.setLayoutX(120);
        undoButton.setLayoutY(150);
        undoButton.setStyle("-fx-background-color: blue; -fx-font-size: 24px; -fx-text-fill: black;");
        undoButton.setOnMouseClicked(event -> {
            if (numberOfUndo>1 ){return;}
            MovingPipes.numberOfClicks -= 1;
            MovingPipes.undo();
            numberOfUndo++;
        });
        anchorPane.getChildren().add(undoButton);
        return undoButton;
    }

    private void autoFill() {
        Label autoFillLabel = new Label("auto fill");
        autoFillLabel.setLayoutX(120);
        autoFillLabel.setLayoutY(300);
        autoFillLabel.setStyle("-fx-background-color: red; -fx-font-size: 14px; -fx-text-fill: black;");
        autoFillLabel.setOnMouseClicked(event -> {
            if (numberOfAutoFill>5) {return;}
            numberOfAutoFill ++;
            outerLoop:
            for (int i = 0; i<map.length; i++) {
                for (int j = 0; j<map[0].length; j++) {
                    if (solution[i][j] != map[i][j].getState() && solution[i][j] != 0) {
                        while (solution[i][j] != map[i][j].getState()) {
                            System.out.println("here");
                            map[i][j].setImageViewRotate();
                        }
                        break outerLoop;
                    }
                }
            }
        });
        anchorPane.getChildren().add(autoFillLabel);
    }
}
