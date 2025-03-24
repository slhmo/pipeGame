package application.project;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class PlayLevelThree extends PlayLevelTwo{
    private Label undoButton;

    public PlayLevelThree(AnchorPane anchorPane, int[][] solution, int maxMoves) {
        super(anchorPane, solution, maxMoves);
        this.undoButton = generateUndoButton();
    }

    private Label generateUndoButton() {
        this.undoButton = new Label();
        undoButton.setText("undo");
        undoButton.setLayoutX(120);
        undoButton.setLayoutY(150);
        undoButton.setOnMouseClicked(event -> {
            MovingPipes.numberOfClicks -= 1;
        });
        anchorPane.getChildren().add(undoButton);
        return undoButton;
    }
}
