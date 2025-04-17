package application.project;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class PlayLevelOne {
    AnchorPane anchorPane;
    int[][] solution;
    BaseBlock[][] map;
    public boolean validated;
    int maxMoves;
    private static final double startX = 710;
    private static final double startY = 50;
    private static final double cellSize = 100;

    public PlayLevelOne(AnchorPane anchorPane, int [][] solution, int maxMoves) {
        this.anchorPane = anchorPane;
        this.solution = solution;
        this.maxMoves = maxMoves;
        generateScene();
    }

    private void placeInputPipe(BaseBlock [][] map, int i, int j) {
        InputPipe inputPipe = new InputPipe();
        map[i][j] = inputPipe;
        ImageView inputPipeImageView = inputPipe.getImageView();
        anchorPane.getChildren().add(inputPipeImageView);
        inputPipeImageView.setY(startY+cellSize*i);
        inputPipeImageView.setX(startX+cellSize*j);
        inputPipeImageView.setFitHeight(cellSize);
        inputPipeImageView.setFitWidth(cellSize);
    }

    private void placeOutputPipe(BaseBlock [][] map, int i, int j) {
        OutputPipe outputPipe = new OutputPipe();
        map[i][j] = outputPipe;
        ImageView outputPipeImageView = outputPipe.getImageView();
        anchorPane.getChildren().add(outputPipeImageView);
        outputPipeImageView.setY(startY+cellSize*i);
        outputPipeImageView.setX(startX+cellSize*j);
        outputPipeImageView.setFitHeight(cellSize);
        outputPipeImageView.setFitWidth(cellSize);
    }

    private void placeInteractiveStraightPipe(BaseBlock [][] map, int i, int j) {
        InteractiveStraightPipe straightPipe = new InteractiveStraightPipe("StraightPipe.png");
        map[i][j] = straightPipe;
        ImageView straightPipeImageView = straightPipe.getImageView();
        anchorPane.getChildren().add(straightPipeImageView);
        straightPipeImageView.setY(startY+cellSize*i);
        straightPipeImageView.setX(startX+cellSize*j);
        straightPipeImageView.setFitHeight(cellSize);
        straightPipeImageView.setFitWidth(cellSize);
    }

    private void placeInteractiveBendingPipe(BaseBlock [][] map, int i, int j) {
        InteractiveBendingPipe elbowBendingPipe = new InteractiveBendingPipe("ElbowBendingPipe.png");
        map[i][j] = elbowBendingPipe;
        ImageView elbowBendingPipeImageView = elbowBendingPipe.getImageView();
        anchorPane.getChildren().add(elbowBendingPipeImageView);
        elbowBendingPipeImageView.setY(startY+cellSize*i);
        elbowBendingPipeImageView.setX(startX+cellSize*j);
        elbowBendingPipeImageView.setFitHeight(cellSize);
        elbowBendingPipeImageView.setFitWidth(cellSize);
    }

    protected void placeInteractiveCrossingPipe(BaseBlock [][] map, int i, int j){System.out.println("level one does not accept crossing pipes"+i+" "+ j);}

    protected void placeConstantCrossingPipe(BaseBlock [][] map, int i, int j){System.out.println("level one does not accept constant pipes"+i+" "+ j);}

    protected void placeConstantStraightPipe(BaseBlock [][] map, int i, int j){System.out.println("level one does not accept constant pipes"+i+" "+ j);}

    protected void placeConstantElbowBendingPipe(BaseBlock [][] map, int i, int j){System.out.println("level one does not accept constant pipes"+i+" "+ j);}

    protected void generateMap(){
        this.map = new BaseBlock[solution.length][solution[0].length];

        for(int i = 0; i<solution.length; i++) {
            for (int j = 0; j<solution[0].length; j++) {
                if (solution[i][j] == 0) {

                    int random = new Random().nextInt(10);
                    if (random<8) {map[i][j] = new EmptyBlock();}
                    else if (random == 9) {
                        placeInteractiveStraightPipe(map, i, j);
                    }
                    else {
                        placeInteractiveBendingPipe(map, i, j);
                    }
                }
                else if (solution[i][j] == 1 || solution[i][j] == 2){
                    placeInteractiveStraightPipe(map, i, j);
                }
                else if(solution[i][j] == 3 || solution[i][j]==4 || solution[i][j]==5 || solution[i][j]==6) {
                    placeInteractiveBendingPipe(map, i, j);
                }
                else if(solution[i][j] == 7) {
                    placeInputPipe(map, i, j);
                }
                else if (solution[i][j] == 8) {
                    placeOutputPipe(map, i, j);
                }
                else if (solution[i][j] == 9) {
                    placeInteractiveCrossingPipe(map, i, j);
                }
                else if (solution[i][j] == 10) {
                    placeConstantCrossingPipe(map, i, j);
                }
                else if(solution[i][j] == 11 || solution[i][j] == 12) {
                    placeConstantStraightPipe(map, i, j);
                }
                else if(solution[i][j] == 13 || solution[i][j] == 14 || solution[i][j] == 15 || solution[i][j] == 16) {
                    placeConstantElbowBendingPipe(map, i, j);
                }
            }
        }
    }

    public void validateMap() {
        System.out.println("validate called");
        validated = true;
        for (int i=0; i<map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j].getState() != solution[i][j] && solution[i][j] != 0) {
                    validated = false;
                    break;
                }
            }
        }
        printMap();
        System.out.println("validated: " + validated);
    }

    protected void generateGrid() {
        // generate grid in between cells
        for (int i=1; i<map.length; i++) {
            Line line = new Line(startX+i*cellSize, startY, startX+i*cellSize, startY+map[0].length*cellSize);
            line.setStrokeWidth(1);
            anchorPane.getChildren().add(line);
        }
        for (int j=1; j< map[0].length; j++) {
            Line line = new Line(startX, startY+j*cellSize, startX+map.length*cellSize, startY+j*cellSize);
            line.setStrokeWidth(1);
            anchorPane.getChildren().add(line);
        }

        // generate border for outside the cells
        Rectangle rectangle = new Rectangle(startX, startY, map.length*cellSize, map[0].length*cellSize);
        rectangle.setStrokeWidth(3);
        rectangle.setFill(null);
        rectangle.setStroke(Color.BLACK);
        anchorPane.getChildren().add(rectangle);
    }

    public void printMap() {
        for (BaseBlock[] baseBlocks : map) {
            System.out.print("[");
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(baseBlocks[j].getState());
            }
            System.out.print("]\n");
        }
    }

    protected void generateScene() {
        System.out.println("generate called");
        generateMap();
        generateGrid();
        anchorPane.setOnMouseClicked(event -> {
            validateMap();
        });
    }

    public BaseBlock[][] getMap() {
        return map;
    }
}
