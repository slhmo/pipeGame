package application.project;

public class InteractiveCrossingPipes extends MovingPipes{
    @Override
    protected int[] setPossibleStates() {
        return new int[]{9};
    }

    public InteractiveCrossingPipes(String path) {
        super(path);
    }
}
