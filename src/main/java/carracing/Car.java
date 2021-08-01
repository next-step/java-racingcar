package carracing;

public class Car {
    private String location;
    private static final int MOVE_NUMBER = 4;

    public Car() {
        this.location = "";
    }

    public String location() {
        return location;
    }

    public void forward() {
        this.location += "-";
    }

    public boolean isMovable(int cmd) {
        return cmd >= MOVE_NUMBER;
    }

    public String move(int cmd) {
        if (isMovable(cmd)) {
            forward();
        }
        return this.location;
    }
}
