package carracing.domain;

public class Car {
    private int location;

    public Car() {
        this.location = 0;
    }

    public int getLocation() {
        return location;
    }

    public void move() {
        location++;
    }
}
