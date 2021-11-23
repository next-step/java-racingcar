package racing.winner.domain;

import java.util.Objects;

public class Car {

    private final static int FORWARD_CONDITION = 4;
    private final static int ONE = 1;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    protected void moveOrStop(int diceNumber) {
        if(FORWARD_CONDITION <= diceNumber) {
            position += ONE;
        }
    }

    protected int getDrivingDistance() {
        return this.position;
    }

    protected String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
