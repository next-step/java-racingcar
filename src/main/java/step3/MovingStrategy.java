package step3;

public class MovingStrategy {
    private static final int MOVING_THRESHOLD = 4;
    private final int input;

    public MovingStrategy(int input) {
        this.input = input;
    }

    public Boolean run() {
        return this.input >= 4;
    }
}
