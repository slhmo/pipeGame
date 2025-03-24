package application.project;

import javafx.scene.image.ImageView;

public class ConstantStraightPipe extends ConstantPipe{
    private int state = 11;
    private final ImageView imageView = new ImageView("StraightPipe.png");

    @Override
    public void setState(int state) {
        if(state==11) {
            this.state = state;
        }
        else if(state==12) {
            imageView.setRotate(90);
            this.state = state;
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
