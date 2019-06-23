package carRacing.model;

import com.google.common.base.Strings;
import java.util.Objects;

public class Car {

    final static int MOVEMENT_LIMIT_BY_OUTPUT = 4;
    private String name;
    private int position;

    public Car(String name) {
        if(Strings.isNullOrEmpty(name)) throw new IllegalArgumentException("");
        this.name = name;
    }

    public Car(String name, int position) {
        if(Strings.isNullOrEmpty(name)) throw new IllegalArgumentException("");
        this.name = name;
        this.position = position;
    }

    public int move(int gamePoint) {
        if (canMove(gamePoint)) {
            position ++;
        }
        return position;
    }

    public boolean isWinner(int bestPosition) {
        return position == bestPosition;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private boolean canMove(int output) {
        return MOVEMENT_LIMIT_BY_OUTPUT <= output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
