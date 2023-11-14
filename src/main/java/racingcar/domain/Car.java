package racingcar.domain;

public class Car {
    private static final int MOVABLE_THRESHOLD = 4;
    private static final int MAX_NAME_LENGTH = 5;

    private Position position = new Position(0);
    private final String name;


    public Car() {
        this.name = "";
    }

    public Car(final String name) {
        validateNameLen(name);
        this.name = name;
    }

    public Car(int position, String name) {
        validateNameLen(name);
        this.position = new Position(position);
        this.name = name;
    }

    public void moveForward(int input) {
        if (input >= MOVABLE_THRESHOLD) {
            position.move();
        }
    }

    private void validateNameLen(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차명은 5글자를 넘길 수 없습니다 : " + name);
        }
    }

    public Position getPosition() {
        return this.position;
    }

    public String getName() {
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
}
