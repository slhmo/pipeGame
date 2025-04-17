package application.project;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class PlayLevelTwo extends PlayLevelOne{
    Label maxMovesLabel;
//    protected BaseBlock[][] previousMap;

    public PlayLevelTwo(AnchorPane anchorPane, int[][] solution, int maxMoves) {
        super(anchorPane, solution, maxMoves);
        this.maxMovesLabel = generateMoveCounter(maxMoves);
    }
    @Override
    protected void placeInteractiveCrossingPipe(BaseBlock [][] map, int i, int j) {
        InteractiveCrossingPipe crossingPipe = new InteractiveCrossingPipe("CrossingPipe.png");
        map[i][j] = crossingPipe;
        ImageView crossingPipeImageView = crossingPipe.getImageView();
        anchorPane.getChildren().add(crossingPipeImageView);
        crossingPipeImageView.setY(50+100*i);
        crossingPipeImageView.setX(710+100*j);
        crossingPipeImageView.setFitHeight(100);
        crossingPipeImageView.setFitWidth(100);
    }

    @Override
    protected void placeConstantCrossingPipe(BaseBlock [][] map, int i, int j) {
        ConstantCrossingPipe constantCrossingPipe = new ConstantCrossingPipe();
        map[i][j] = constantCrossingPipe;
        ImageView constantCrossingPipeImageView = constantCrossingPipe.getImageView();
        anchorPane.getChildren().add(constantCrossingPipeImageView);
        constantCrossingPipeImageView.setY(50+100*i);
        constantCrossingPipeImageView.setX(710+100*j);
        constantCrossingPipeImageView.setFitHeight(100);
        constantCrossingPipeImageView.setFitWidth(100);
    }

    @Override
    protected void placeConstantStraightPipe(BaseBlock [][] map, int i, int j) {
        ConstantStraightPipe constantStraightPipe = new ConstantStraightPipe();
        map[i][j] = constantStraightPipe;
        ImageView constantStraightPipeImageView = constantStraightPipe.getImageView();
        anchorPane.getChildren().add(constantStraightPipeImageView);
        constantStraightPipeImageView.setY(50+100*i);
        constantStraightPipeImageView.setX(710+100*j);
        constantStraightPipeImageView.setFitHeight(100);
        constantStraightPipeImageView.setFitWidth(100);
    }

    @Override
    protected void placeConstantElbowBendingPipe(BaseBlock [][] map, int i, int j) {
        ConstantBendingPipe constantBendingPipe = new ConstantBendingPipe();
        map[i][j] = constantBendingPipe;
        ImageView constantBendingPipeImageView = constantBendingPipe.getImageView();
        anchorPane.getChildren().add(constantBendingPipeImageView);
        constantBendingPipeImageView.setY(50+100*i);
        constantBendingPipeImageView.setX(710+100*j);
        constantBendingPipeImageView.setFitHeight(100);
        constantBendingPipeImageView.setFitWidth(100);
    }

    @Override
    protected void generateScene() {
        System.out.println("generate called");
        generateMap();
        generateGrid();
        anchorPane.setOnMouseClicked(event -> {
//            previousMap = map.clone();
            validateMap();
            updateMoveCounter(maxMoves);
        });
    }

    public Label generateMoveCounter(int maxMoves) {
        this.maxMovesLabel = new Label();
        maxMovesLabel.setText(String.format("moves left: %d", maxMoves- InteractivePipe.getNumberOfClicks()));
        maxMovesLabel.setLayoutX(100);
        maxMovesLabel.setLayoutY(100);
        anchorPane.getChildren().add(maxMovesLabel);
        return maxMovesLabel;
    }

    public void updateMoveCounter(int maxMoves) {
        System.out.println("max: "+maxMoves);
        System.out.println("moves: "+ InteractivePipe.getNumberOfClicks());
        maxMovesLabel.setText(String.format("moves left: %d", maxMoves- InteractivePipe.getNumberOfClicks()));
    }

}
