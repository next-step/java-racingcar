package racingcar;

import java.util.Objects;

public class Car {

    private int move;

    public Car(int move) {
        this.move = move;
    }

    public Car() {
        this.move = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return move == car.move;
    }

    @Override
    public int hashCode() {
        return Objects.hash(move);
    }

    @Override
    public String toString() {
        return "Car{" +
                "move=" + move +
                '}';
    }

    public void moveForward() {
        this.move ++;
    }

    public String printMovedDistance() {
        String moved = "";
        for (int i = 0; i < this.move; i++) {
            moved += "-";
        }
        return moved;
    }
}
