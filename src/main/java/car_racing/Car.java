package car_racing;

import java.util.Objects;

public class Car {

    private static final int START_POSITION = 0;
    private final Name name;
    private int position;

    public Car() {
        // 부 생성자
        this(START_POSITION);
    }

    public Car(int position) {
        // 주 생성자
        this(position, null);
    }

    public Car(String name) {
        this(START_POSITION, name);
    }

    public Car(int position, String name) {
        this.position = position;
        this.name = new Name(name);
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
