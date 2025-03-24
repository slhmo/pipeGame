package application.project;

import javafx.scene.image.ImageView;

public class InputPipe extends BaseBlock{
    private static final int state = 7;
    private final ImageView imageView;

    public InputPipe() {
        imageView = new ImageView("InputOutput.png");
    }

    public int getState() {
        return state;
    }

    @Override
    public ImageView getImageView() {
        return imageView;
    }
}
