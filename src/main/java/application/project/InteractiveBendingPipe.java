package application.project;

import java.util.Random;

public class InteractiveBendingPipe extends InteractivePipe {
    public InteractiveBendingPipe(String path) {
        super(path);
    }

    @Override
    protected int[] setPossibleStates() {
        return new int[]{3, 4, 5, 6};
    }

    @Override
    protected int setInitialState(int[] states) {
        int random = new Random().nextInt(states.length);
        if (states[random] == 4) {
            imageView.setRotate(90);
        }
        else if (states[random] == 5) {
            imageView.setRotate(180);
        }
        else if (states[random] == 6) {
            imageView.setRotate(270);
        }
        return states[random];
    }
}
