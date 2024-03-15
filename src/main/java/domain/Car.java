package domain;

public class Car {
    private static final int ADVANCE_CONDITION_NUMBER = 4;

    private int position = 1;
    private Name name;

    public Car() {
    }

    public Car(final Name name) {
        this.name = name;
    }

    public static Car createCar(final Name carName) {
        return new Car(carName);
    }

    public void move(int number) {
        if (number >= ADVANCE_CONDITION_NUMBER) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }
}
