package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new RuntimeException("자동차 목록이 비어있습니다");
        }

        this.cars = new ArrayList<>(cars);
    }

    public void tryAdvance(final CarMoveGenerator carMoveGenerator) {
        cars.forEach(car -> car.advance(carMoveGenerator.advance()));
    }

    public List<Car> getCars() {
        return cars;
    }
}
