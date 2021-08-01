package carracing;

public class Car {
    private String location;

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
        return cmd >= 4;
    }

    public void ordered(int cmd) {
        if (isMovable(cmd)) {
            forward();
        }
    }
}
