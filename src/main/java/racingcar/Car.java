package racingcar;

import java.util.Objects;

public class Car {

    private static final int START_POSITION = 0;

    private int position = START_POSITION;
    private final String nickname;

    public Car(String nickname) {
        this.nickname = nickname;
    }

    public void move(Condition carCondition) {
        if (carCondition.inspect()) {
            this.position = position + 1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return this.nickname;
    }
}
