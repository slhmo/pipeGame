package application.project;

import javafx.scene.image.ImageView;

public class OutputPipe extends BaseBlock{
    private static final int state = 8;
    private final ImageView imageView;

    public OutputPipe() {
        imageView = new ImageView("InputOutput.png");
        imageView.setRotate(90);
    }

    public int getState() {
        return state;
    }

    @Override
    public ImageView getImageView() {
        return imageView;
    }
}
