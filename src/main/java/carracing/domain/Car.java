package carracing.domain;

public class Car {

    private static final int MOVE_NUMBER = 4;

    private int location;

    public Car() {
        this.location = 0;
    }

    public int location() {
        return location;
    }

    public void forward() {
        this.location++;
    }

    public boolean isMovable(int cmd) {
        return cmd >= MOVE_NUMBER;
    }

    public int move(int cmd) {
        if (isMovable(cmd)) {
            forward();
        }
        return this.location;
    }
}
