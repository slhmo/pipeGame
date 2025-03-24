package application.project;

import javafx.scene.image.ImageView;

public class ConstantCrossingPipe extends ConstantPipe{
    private static final int state = 10;
    private final ImageView imageView = new ImageView("CrossingPipe.png");
    @Override
    public void setState(int state) {}

    @Override
    public int getState() {
        return state;
    }

    @Override
    public ImageView getImageView() {
        return imageView;
    }
}
