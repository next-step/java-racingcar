package car_racing;

import java.util.Objects;

public class Car {

    private static final int START_POSITION = 0;

    private final Name name;
    private int position;

    public Car(Name name) {
        this(START_POSITION, name);
    }

    public Car(int position, Name name) {
        this.position = position;
        this.name = name;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.decideToMove()) {
            position ++;
        }
    }

    public int getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }

    public String getStringName() {
        return name.getString();
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
        return position == car.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
