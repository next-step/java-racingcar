package racingcar.service.domain;

import racingcar.service.strategy.RoundRule;
import racingcar.service.value.Position;
import racingcar.utils.Preconditions;

import java.util.Objects;

public class Car implements Cloneable {
    private static final int CAR_NAME_MAXIMUM_SIZE = 6;
    private static final Integer INIT_POSITION = 0;

    private final String name;
    private final Position position;

    public Car(String name) {
        this(name, Position.from(INIT_POSITION));
    }

    public Car(String name, Position position) {
        Preconditions.checkString(name, "name은 필수값입니다.");
        Preconditions.checkMaximumSize(name.length(), CAR_NAME_MAXIMUM_SIZE,
                                       String.format("maximumSize(%d) 값보다 작은 값을 입력해 주세요.", name.length()));
        Preconditions.checkNotNull(position, "position는 필수값입니다.");

        this.name = name;
        this.position = position;
    }


    public void startRace(RoundRule roundRule) {
        if (roundRule.checkCondition()) {
            position.increasePosition();
        }
    }

    public String getName() {
        return name;
    }

    public Position getCurrentPosition() {
        return position;
    }

    @Override
    public Car clone() {
        return new Car(name, Position.from(position.getPosition()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}