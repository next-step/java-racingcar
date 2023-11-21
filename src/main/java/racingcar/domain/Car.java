package racingcar.domain;

public class Car {
    private static final int MOVABLE_THRESHOLD = 4;
    private Position position = new Position(0);
    private Name name = new Name("");


    public Car() {
    }

    public Car(final String name) {
        this.name = new Name(name);
    }

    public Car(int position, String name) {
        this.position = new Position(position);
        this.name = new Name(name);
    }

    public void moveForward(int input) {
        if (input >= MOVABLE_THRESHOLD) {
            position.move();
        }
    }

    public Position getPosition() {
        return this.position;
    }

    public Name getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
