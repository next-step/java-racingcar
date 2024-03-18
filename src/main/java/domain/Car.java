package domain;

public class Car {
    private static final int ADVANCE_CONDITION_NUMBER = 4;

    private Position position;
    private Name name;

    private Car() {
    }

    public Car(final Name name, final Position position) {
        this.position = position;
        this.name = name;
    }

    public static Car createCar(final Name carName) {
        return new Car(carName, new Position(1));
    }

    public String getName() {
        return name.getName();
    }

    public void move(int number) {
        if (number >= ADVANCE_CONDITION_NUMBER) {
            position.increment();
        }
    }

    public Integer getPositionNumber() {
        return position.getPosition();
    }
}
