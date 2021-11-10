package step3.domain;

import step3.domain.history.RoundHistory;
import step3.service.IntNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Participant {
    private static final String COMMA = ",";

    private Cars cars;

    private Participant() {
    }

    private Participant(Cars cars) {
        validateIsEmpty(cars);
        this.cars = cars;
    }

    public static Participant join(String names) {
        return new Participant(createCars(names));
    }

    public RoundHistory move(IntNumberGenerator generator) {
        return new RoundHistory(cars.move(generator));
    }

    private static Cars createCars(String names) {
        List<Car> carList = new ArrayList<>();
        for (String name : splitCarNames(names)) {
            carList.add(Car.create(name));
        }
        return Cars.join(carList);
    }

    private static String[] splitCarNames(String names) {
        return names.split(COMMA);
    }

    private void validateIsEmpty(Cars cars) {
        if (Objects.isNull(cars)) {
            throw new IllegalArgumentException("경주에 참여할 자동차가 존재하지 않습니다.");
        }
    }
}
