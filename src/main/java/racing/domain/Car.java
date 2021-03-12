package racing.domain;

public class Car implements ReadonlyCar {

    private static final int NAME_LENGTH_LIMIT = 5;

    private final Movement movement;
    private final String name;
    private int location = 0;

    public Car(Movement movement, String name) {
        validateNameIsNotNullAndNotEmpty(name);
        validateLengthOfName(name);

        this.movement = movement;
        this.name = name;
    }

    public void move() {
        location += movement.move();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLocation() {
        return location;
    }

    private void validateNameIsNotNullAndNotEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new CarNameException();
        }
    }

    private void validateLengthOfName(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new CarNameException();
        }
    }

}
