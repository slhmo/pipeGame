package application.project;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import java.util.Random;

public abstract class MovingPipes extends BaseBlock {
    // has a possibleStates field which the state will be chosen from there.
    // has an imageView and sets some properties for it.(Mouse click and enter...)
    protected ImageView imageView;
    protected final int[] possibleStates;
    private int state;
    protected static int numberOfClicks;
    private MouseButton latestMouseButton;
    private static MovingPipes usedPipe;

    public MovingPipes(String path) {
        imageView = new ImageView(path);
        possibleStates = setPossibleStates();
        state = setInitialState(possibleStates);
        setImageViewProperties();
    }

    public void setImageViewProperties() {
        imageView.setOnMouseClicked(event -> {
            numberOfClicks += 1;
            latestMouseButton = event.getButton();
            usedPipe = this;

            System.out.println(this.state);
            if (event.getButton() == MouseButton.PRIMARY) {
                imageView.setRotate(imageView.getRotate()+90);
                state = MovingPipesStates.setState(state, MouseButton.PRIMARY);
            }
            else if (event.getButton() == MouseButton.SECONDARY) {
                imageView.setRotate(imageView.getRotate()-90);
                state = MovingPipesStates.setState(state, MouseButton.SECONDARY);
            }
        });
        imageView.setOnMouseEntered(event -> {
            imageView.setOpacity(0.6);
        });
        imageView.setOnMouseExited(event -> {
            imageView.setOpacity(1);
        });
    }

    protected int setInitialState(int[] states) {
        int random = new Random().nextInt(states.length);
        return states[random];
    }

    public static void undo() {
        if (usedPipe.latestMouseButton == MouseButton.PRIMARY) {
            usedPipe.imageView.setRotate(usedPipe.imageView.getRotate()-90);
            usedPipe.state = MovingPipesStates.setState(usedPipe.state, MouseButton.SECONDARY);
        }
        else if (usedPipe.latestMouseButton == MouseButton.SECONDARY) {
            usedPipe.imageView.setRotate(usedPipe.imageView.getRotate()+90);
            usedPipe.state = MovingPipesStates.setState(usedPipe.state, MouseButton.PRIMARY);
        }
    }


    public int getState() {
        return state;
    }

    @Override
    public void setState(int state) {
        this.state = state;
    }

    public static void setNumberOfClicks(int num) {
        numberOfClicks = num;
    }
    @Override
    public ImageView getImageView() {
        return imageView;
    }

    protected int[] setPossibleStates() {
        return new int[]{1, 2, 3, 4, 5, 6, 9};
    }
    public static int getNumberOfClicks() {
        return numberOfClicks;
    }

    @Override
    public void setImageViewRotate() {
        imageView.setRotate(imageView.getRotate()+90);
        state = MovingPipesStates.setState(state, MouseButton.PRIMARY);
    }

}
