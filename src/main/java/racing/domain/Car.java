package racing.domain;

public class Car {

    public static final int FORWARD_STANDARD_NUMBER = 4;

    private Name name;
    private Position position;

    public Car(String name) {
        this(name, new Position(0));
    }

    public Car(String name, Position position) {
        this.name = new Name(name);
        this.position = position;
    }

    public String getName() {
        return name.toString();
    }

    public Position getPosition() {
        return position;
    }

    public boolean isWinner(Position maxPosition) {
        return maxPosition == this.position;
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
