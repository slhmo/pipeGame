package application.project;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;

public abstract class BaseBlock {
    private static int state = -1;
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

    public void setState(int i) {
        state = i;
    }

    public void setImageViewRotate() {}
}
