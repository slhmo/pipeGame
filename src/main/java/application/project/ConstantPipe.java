package application.project;

import javafx.scene.image.ImageView;

public abstract class ConstantPipe extends BaseBlock{
    private static final int state = -2;
    public int getState() {
        return state;
    }

    public abstract void setState(int state);

    @Override
    public abstract ImageView getImageView();
}
