package application.project;

import java.util.Random;


public class InteractiveStraightPipe extends InteractivePipe {
    public InteractiveStraightPipe(String path) {
        super(path);
    }

    @Override
    protected int[] setPossibleStates() {
        return new int[]{1, 2};
    }

    @Override
    protected int setInitialState(int[] states) {
        int random = new Random().nextInt(states.length);
        if (states[random] == 2) {
            imageView.setRotate(90);
        }
        return states[random];
    }
}
