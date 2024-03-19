package racingcar;


import java.util.Objects;

public class Car {
    private static final int STEP_HURDLE = 4;
    private static final int CAR_NAME_ALLOWED_LENGTH = 5;


    private int position = 0;
    private String name;

    public Car() {
    }

    public Car(String name) {
        if (CAR_NAME_ALLOWED_LENGTH < name.length()) {
            throw new IllegalArgumentException("car name should be under 5");
        }
        this.name = name;
    }

    public void moveForward(int value) {
        if (value < STEP_HURDLE) {
            return;
        }
        position += 1;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
