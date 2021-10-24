package racingcar.domains;

import racingcar.strategies.MoveStrategy;
import racingcar.utils.StringUtils;

import java.util.Objects;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        validateCarName(name);
        this.name = name;
        this.position = position;
    }

    private void validateCarName(String name) {
        boolean result = StringUtils.isLengthWithinLimits(1, 5, name);
        if (!result) {
//            throw new Exception("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
