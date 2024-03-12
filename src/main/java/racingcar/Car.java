package racingcar;

public class Car {
    private static final int ADVANCE_CONDITION_NUMBER = 4;

    private int position = 1;
    private String name;

    public Car() {
    }

    public Car(final String name) {
        this.name = name;
    }

    public static Car createCar(final String carName) {
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

    public String getName() {
        return name;
    }
}
