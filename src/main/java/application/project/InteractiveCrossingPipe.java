package application.project;

public class InteractiveCrossingPipe extends InteractivePipe {
    @Override
    protected int[] setPossibleStates() {
        return new int[]{9};
    }

    public InteractiveCrossingPipe(String path) {
        super(path);
    }
}
