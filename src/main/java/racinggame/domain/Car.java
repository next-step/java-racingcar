package racinggame.domain;

import static racinggame.view.OutputView.*;

import java.util.Objects;

public class Car {

    public static final int MIN_MOVE_NUMBER = 0;
    public static final int MAX_MOVE_NUMBER = 9;

    private CarPosition position;
    private final CarName name;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new CarPosition();
    }

    public Car(String name, int position) {
        this(name);
        this.position = new CarPosition(position);
    }

    public String move(int number) {
        validateNumber(number);
        this.position = this.position.move(number);
        return getPositionDisplay(this);
    }

    private void validateNumber(int number) {
        if (number < MIN_MOVE_NUMBER || number > MAX_MOVE_NUMBER) {
            throw new IllegalArgumentException("0부터 9까지의 숫자만 입력할 수 있습니다.");
        }
    }

    public boolean isWinnerWith(int targetPosition) {
        return position.isGreaterThanOrEqual(targetPosition);
    }

    public int compareAndReturnMax(int currentMax) {
        return position.compareAndReturnMax(currentMax);
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
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
        return Objects.hash(position, name);
    }

    @Override
    public String toString() {
        return "Car{" + "position=" + position.getPosition() + ", name='" + name.getName() + '\'' + '}';
    }
}
