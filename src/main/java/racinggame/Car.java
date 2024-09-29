package racinggame;

public class Car {
    private final int position;

    private Car() {
        this.position = 0;
    }

    public static Car create() {
        return new Car();
    }

    public int getPosition() {
        return position;
    }
}
