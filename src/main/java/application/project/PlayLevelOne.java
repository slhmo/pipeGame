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
        inputPipeImageView.setY(50+100*i);
        inputPipeImageView.setX(710+100*j);
        inputPipeImageView.setFitHeight(100);
        inputPipeImageView.setFitWidth(100);
    }

    private void placeOutputPipe(BaseBlock [][] map, int i, int j) {
        OutputPipe outputPipe = new OutputPipe();
        map[i][j] = outputPipe;
        ImageView outputPipeImageView = outputPipe.getImageView();
        anchorPane.getChildren().add(outputPipeImageView);
        outputPipeImageView.setY(50+100*i);
        outputPipeImageView.setX(710+100*j);
        outputPipeImageView.setFitHeight(100);
        outputPipeImageView.setFitWidth(100);
    }

    private void placeStraightPipe(BaseBlock [][] map, int i, int j) {
        StraightPipes straightPipe = new StraightPipes("StraightPipe.png");
        map[i][j] = straightPipe;
        ImageView straightPipeImageView = straightPipe.getImageView();
        anchorPane.getChildren().add(straightPipeImageView);
        straightPipeImageView.setY(50+100*i);
        straightPipeImageView.setX(710+100*j);
        straightPipeImageView.setFitHeight(100);
        straightPipeImageView.setFitWidth(100);
    }

    private void placeElbowBendingPipe(BaseBlock [][] map, int i, int j) {
        ElbowBendingPipes elbowBendingPipe = new ElbowBendingPipes("ElbowBendingPipe.png");
        map[i][j] = elbowBendingPipe;
        ImageView elbowBendingPipeImageView = elbowBendingPipe.getImageView();
        anchorPane.getChildren().add(elbowBendingPipeImageView);
        elbowBendingPipeImageView.setY(50+100*i);
        elbowBendingPipeImageView.setX(710+100*j);
        elbowBendingPipeImageView.setFitHeight(100);
        elbowBendingPipeImageView.setFitWidth(100);
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
                        placeStraightPipe(map, i, j);
                    }
                    else {
                        placeElbowBendingPipe(map, i, j);
                    }
                }
                else if (solution[i][j] == 1 || solution[i][j] == 2){
                    placeStraightPipe(map, i, j);
                }
                else if(solution[i][j] == 3 || solution[i][j]==4 || solution[i][j]==5 || solution[i][j]==6) {
                    placeElbowBendingPipe(map, i, j);
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
            Line line = new Line(710+i*100, 50, 710+i*100, 50+map[0].length*100);
            line.setStrokeWidth(1);
            anchorPane.getChildren().add(line);
        }
        for (int j=1; j< map[0].length; j++) {
            Line line = new Line(710, 50+j*100, 710+map.length*100, 50+j*100);
            line.setStrokeWidth(1);
            anchorPane.getChildren().add(line);
        }

        // generate border for outside the cells
        Rectangle rectangle = new Rectangle(710, 50, map.length*100, map[0].length*100);
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
