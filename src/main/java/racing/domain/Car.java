package racing.domain;

public class Car {

    public static final int FORWARD_STANDARD_NUMBER = 4;

    private String name;
    private Position position;

    public Car(String name) {
        this(name, new Position(0));
    }

    public Car(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void move(int value) {
        if(isAvailableForward(value)) {
            position = new Position(this.position.getValue() + 1);
        }
    }

    private boolean isAvailableForward(int value) {
        return value >= FORWARD_STANDARD_NUMBER;
    }
}
