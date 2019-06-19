package carRacing.model;

import com.google.common.base.Strings;

import java.util.Objects;

public class Car {

    private final static int MOVEMENT_LIMIT_BY_OUTPUT = 4;
    private String name;
    private int position;

    public Car(String name) {
        if(Strings.isNullOrEmpty(name)) throw new IllegalArgumentException("");
        this.name = name;
    }

    public int move(int gamePoint) {
        if (canMove(gamePoint)) {
            position ++;
        }
        return position;
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
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private boolean canMove(int output) {
        return MOVEMENT_LIMIT_BY_OUTPUT <= output;
    }

}
