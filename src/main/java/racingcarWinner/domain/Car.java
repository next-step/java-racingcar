package racingcarWinner.domain;

import java.util.Objects;

public class Car {

    private String name;
    private int position;
    private boolean finalWinner = false;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isFinalWinner() {
        return finalWinner;
    }

    public void move() {
        this.position++;
    }

    public void prizeWinner() {
        this.finalWinner = true;
    }

    public boolean isEqualPosition(int inputPosition) {
        return this.position == inputPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return position == car.position &&
                finalWinner == car.finalWinner &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, finalWinner);
    }
}
