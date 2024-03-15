package domain;

public class Car {
    private static final int ADVANCE_CONDITION_NUMBER = 4;

    private Position position;
    private Name name;

    public Car() {
    }

    public Car(final Name name) {
        this.name = name;
    }

    public static Car createCar(final Name carName) {
        return new Car(carName);
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
