package application.project;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainPlay extends Application {
    boolean Initialized = false;
    ImageView backgroundView;
    ImageView cloud;
    Timeline timeline;
    AnchorPane anchorPane;
    Stage stage;
    int state = 0;
    /// state 0: main menu      state 1: level 1      state 2: level 2      state 3: level 3

    MainMenu mainMenu;

    PlayLevelOne playLevelOne;
    int[][] solutionLevelOne;
    BaseBlock[][] levelOneMap;

    PlayLevelTwo playLevelTwo;
    int[][] solutionLevelTwo;
    BaseBlock[][] levelTwoMap;

    PlayLevelThree playLevelThree;
    int[][] solutionLevelThree;
    BaseBlock[][] levelThreeMap;


    int counter;

    @Override
    public void start(Stage stage) {
        this.stage = stage;

        if (!Initialized) {
            Initialized = true;
            //create root scene
            this.anchorPane = new AnchorPane();

            // creating child nodes
            this.backgroundView = new ImageView("background.jpg");
            backgroundView.setFitWidth(1920);
            backgroundView.setFitHeight(1080);
            anchorPane.getChildren().add(backgroundView);
            this.cloud = new ImageView("cloud.png");
            cloud.setFitWidth(380);
            cloud.setFitHeight(150);
            cloud.setX(-380);
            anchorPane.getChildren().add(cloud);
            stage.setFullScreen(true);
            stage.setFullScreenExitHint("press esc to exit fullscreen");
            Scene scene = new Scene(anchorPane, 800, 600);
            stage.setScene(scene);
            stage.show();

            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200), e -> run()));
            this.timeline = timeline;
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        }

        if (Initialized) {
            anchorPane.getChildren().clear();
            anchorPane.getChildren().add(backgroundView);
            anchorPane.getChildren().add(cloud);
        }

        if (state == 0) {
            this.mainMenu = new MainMenu(anchorPane);
        }

        if (state == 1) {
            /// create level one game
            this.solutionLevelOne = new int[][]{{7, 0, 0, 0, 0}, {3, 2, 2, 5, 0}, {4, 2, 2, 6, 0}, {1, 0, 0, 0, 0}, {3, 2, 2, 2, 8}};
            this.playLevelOne = new PlayLevelOne(anchorPane, solutionLevelOne, 0);
            this.levelOneMap = playLevelOne.getMap();
        }

        if (state == 2) {
            /// create level two game
            this.solutionLevelTwo = new int[][]{{7, 0, 0, 0, 0, 0, 0}, {1, 0, 0, 0, 0, 0, 0}, {1, 0, 0, 0, 0, 0, 0},
                    {3, 2, 2, 2, 5, 0, 0}, {0, 4, 2, 2, 6, 0, 0}, {0, 1, 0, 0, 0, 0, 0}, {0, 3, 2, 2, 2, 2, 8}};
            this.playLevelTwo = new PlayLevelTwo(anchorPane, solutionLevelTwo, 15);
            this.levelTwoMap = playLevelTwo.getMap();
        }

        if (state == 3) {
            /// create level two game
            this.solutionLevelThree = new int[][]{{7, 0, 0, 0, 0, 0, 0}, {9, 0, 0, 0, 0, 0, 0}, {10, 0, 0, 0, 0, 0, 0},
                    {3, 2, 2, 2, 5, 0, 0}, {0, 4, 2, 2, 6, 0, 0}, {0, 11, 0, 0, 0, 0, 0}, {0, 13, 2, 2, 2, 2, 8}};
            this.playLevelThree = new PlayLevelThree(anchorPane, solutionLevelThree, 15);
            this.levelThreeMap = playLevelThree.getMap();
        }
    }

    private void run() {
        // cloud animation
        if (cloud.getX() == 1920) {
            cloud.setX(-380);}
        cloud.setX(cloud.getX()+5);

        if (state == 0) {
            if (mainMenu.getState() != 0) {
                state = mainMenu.getState();
                start(stage);
            }
        }

        if (state == 1) {
            // play level one
            if (playLevelOne.validated){
                state = 0;
                MainMenu.setResultWon();
                MovingPipes.setNumberOfClicks(0);
                start(stage);
            }
        }

        if (state == 2) {
            // play level two
            if (MovingPipes.getNumberOfClicks() > playLevelTwo.maxMoves) {
                state = 0;
                MovingPipes.setNumberOfClicks(0);
                MainMenu.setResultLost();
                start(stage);
            }
            if (playLevelTwo.validated){
                state = 0;
                MovingPipes.setNumberOfClicks(0);
                MainMenu.setResultWon();
                start(stage);
            }
        }

        if (state == 3) {
            // play level two
            counter++;
            playLevelThree.setTimerText(String.format("time: %.2f", 30-counter*0.2));
            if (MovingPipes.getNumberOfClicks() > playLevelThree.maxMoves || 30-counter*0.2 < 0) {
                state = 0;
                counter = 0;
                MainMenu.setResultLost();
                MovingPipes.setNumberOfClicks(0);
                start(stage);
            }
            if (playLevelThree.validated){
                state = 0;
                counter = 0;
                MainMenu.setResultWon();
                MovingPipes.setNumberOfClicks(0);
                start(stage);
            }
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
