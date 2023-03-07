package car.domain;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private final Name name;
    private final Position position;

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Car(Name name) {
        this(name, new Position(DEFAULT_POSITION));
    }

    public void move() {
        this.position.increasePosition();
    }

    public boolean isGreaterThan(int maxPosition) {
        return this.position.isGreaterThan(maxPosition);
    }

    public boolean isEqualPosition(int maxPosition) {
        return this.position.isEqualPosition(maxPosition);
    }

    public int findPosition() {
        return this.position.getPosition();
    }
    
    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
