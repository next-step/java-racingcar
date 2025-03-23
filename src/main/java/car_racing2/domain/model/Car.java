package car_racing2.domain.model;

public class Car{
    private static final int DEFAULT_MOVING_DISTANCE = 1;
    private static final String DELIMITER = " : ";
    private static final String END_OF_LINE = "\n";

    private final Name name;
    private final Position position = new Position();

    public Car(String name) {
        this.name = new Name(name);
    }

    public void move() {
        this.position.changePosition(DEFAULT_MOVING_DISTANCE);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getPositionWithName() {
        return name + DELIMITER + position + END_OF_LINE;
    }
}
