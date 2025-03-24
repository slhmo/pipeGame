package application.project;

import javafx.scene.image.ImageView;

public abstract class BaseBlock {
    private static final int state = -1;
    protected final ImageView imageView;

    public BaseBlock() {
        imageView = new ImageView("EmptyBlock.png");
    }

    public int getState() {
        return state;
    }

    public ImageView getImageView() {
        return imageView;
    }

}
