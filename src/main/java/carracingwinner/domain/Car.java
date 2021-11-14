package carracingwinner.domain;

public class Car {

    private static final int MOVE_BOUND = 4;

    private Name name;
    private Position position;

    public Car(String name) {
        this(name, new Position());
    }

    public Car(String name, Position position) {
        this.name = new Name(name);
        this.position = position;
    }

    public void move(int moveValue) {
        if (moveValue >= MOVE_BOUND) {
            position = position.move();
        }
    }

    public String showCurrentState() {
        return name.getName() + " : " + position.getStringValue();
    }

    public String getName() {
        return name.getName();
    }

    public Position getPosition() {
        return position;
    }

}
