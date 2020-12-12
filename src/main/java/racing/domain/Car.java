package racing.domain;

import java.util.Objects;

public class Car {
    private int moveCount;
    private Name name;
    private static final int CAN_RUN_MIN_VALUE = 4;

    public Car() {
    }

    public Car(String name) {
        this.moveCount = 0;
        this.name = new Name(name);
    }

    public Name getName() {
        return this.name;
    }

    public void move(int randomNo) {
        if(randomNo >= CAN_RUN_MIN_VALUE) {
            moveCount++ ;
        }
    }

    public int getMoveCount() {
        return moveCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (moveCount != car.moveCount) return false;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        int result = moveCount;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
