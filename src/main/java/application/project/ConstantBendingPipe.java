package application.project;

import javafx.scene.image.ImageView;

public class ConstantBendingPipe extends ConstantPipe{
    private final int state = 13;
    private final ImageView imageView = new ImageView("ElbowBendingPipe.png");

    @Override
    public void setState(int state) {
        if (state>13&&state<17) {
            imageView.setRotate((state-13)*90);
        }
    }
    @Override
    public int getState() {
        return state;
    }

    @Override
    public ImageView getImageView() {
        return imageView;
    }
}
