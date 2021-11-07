package step3.domain;

import java.util.Objects;

public class Participant {
    private final Cars cars;

    private Participant(Cars cars) {
        validateIsEmpty(cars);
        this.cars = cars;
    }

    public static Participant join(Cars cars) {
        return new Participant(cars);
    }

    public void move() {
        cars.move();
    }

    public void showPosition() {
        cars.showPosition();
    }

    private void validateIsEmpty(Cars cars) {
        if (Objects.isNull(cars)) {
            throw new IllegalArgumentException("경주에 참여할 자동차가 존재하지 않습니다.");
        }
    }
}
