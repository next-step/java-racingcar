package racing;

import java.util.Objects;

public class Car {

    private static final int MOVE_CONDITION_NUM = 4;
    private static final int RAND_VALID_LOWER = 0;
    private static final int RAND_VALID_UPPER = 9;

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void moveForward(int rand) {
        checkRandom(rand);
        if (canMove(rand)) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isSamePosition(Car other) {
        return this.getPosition() == other.getPosition();
    }

    private boolean canMove(int rand) {
        return rand >= MOVE_CONDITION_NUM;
    }

    private void checkRandom(int rand) {
        if (rand < RAND_VALID_LOWER || rand > RAND_VALID_UPPER) {
            throw new IllegalArgumentException();
        }
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
}
