package carracingwinner.domain;

public class Car {

    private static final int MOVE_BOUND = 4;

    private Name name;
    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(int moveValue) {
        if (moveValue >= MOVE_BOUND) {
            position = position.move();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getIntValue();
    }

}
