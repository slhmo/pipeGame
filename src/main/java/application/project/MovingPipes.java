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

    public MovingPipes(String path) {
        imageView = new ImageView(path);
        possibleStates = setPossibleStates();
        state = setInitialState(possibleStates);
        setImageViewProperties();
    }

    public void setImageViewProperties() {
        imageView.setOnMouseClicked(event -> {
            numberOfClicks += 1;
//            System.out.println(this.state);
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

    public int getState() {
        return state;
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
    public static void setNumberOfClicks(int num) {
        numberOfClicks = num;
    }
}
