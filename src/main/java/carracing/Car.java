package carracing;

public class Car {
    private static final int MINIMUM_SPEED = 4;
    private int speed;
    private int step;

    public int move(int speed) {
        if (speed < MINIMUM_SPEED) {
            stop();
            return this.step;
        }
        return ++this.step;
    }

    public int stop() {
        return 0;
    }
}
