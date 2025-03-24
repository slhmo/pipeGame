package application.project;

public class CrossingPipes extends MovingPipes{
    @Override
    protected int[] setPossibleStates() {
        return new int[]{9};
    }

    public CrossingPipes(String path) {
        super(path);
    }
}
