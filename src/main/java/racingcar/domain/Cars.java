package racingcar.domain;

import java.util.stream.Collectors;
import racingcar.utils.NumberGenerator;

import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public Round moveForwardCars(final NumberGenerator numberGenerator) {
        Round round = new Round();
        cars.stream().forEach(car -> car.tryMove(numberGenerator.generateNumber()));
        round.recordRound(copyCars());
        return round;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int getMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getCarPosition)
            .max()
            .orElseThrow(() -> new IllegalArgumentException("자동차가 존재하지 않습니다."));
    }

    public Cars copyCars() {
        return new Cars(cars.stream()
            .map(Car::copyCar)
            .collect(Collectors.toList()));
    }

}


