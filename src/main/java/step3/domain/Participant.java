package step3.domain;

import step3.domain.history.RoundHistory;
import step3.service.IntNumberGenerator;

import java.util.Objects;

public class Participant {
    private Cars cars;

    private Participant() {
    }

    private Participant(Cars cars) {
        validateIsEmpty(cars);
        this.cars = cars;
    }

    public static Participant join(Cars cars) {
        return new Participant(cars);
    }

    public RoundHistory move(IntNumberGenerator generator) {
        return new RoundHistory(cars.move(generator));
    }

    private void validateIsEmpty(Cars cars) {
        if (Objects.isNull(cars)) {
            throw new IllegalArgumentException("경주에 참여할 자동차가 존재하지 않습니다.");
        }
    }
}
