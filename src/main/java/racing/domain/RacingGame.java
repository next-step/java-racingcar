package racing.domain;

import racing.domain.car.Cars;
import racing.domain.fuel.Fuel;

import java.util.Objects;

public class RacingGame {
    private final Cars cars;

    public RacingGame(Cars cars) {
        validate(cars);

        this.cars = cars;
    }

    private void validate(Cars cars) {
        if (Objects.isNull(cars) || cars.isEmpty())
            throw new IllegalArgumentException("경기를 진행할 차가 없습니다.");
    }

    public Turn racing(Fuel fuel) {
        return cars.moveAll(fuel);
    }
}
