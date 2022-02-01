package racingcar.domain.racing;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;

public class RacingResult {

    private static final String DELIMITER = ", ";

    private List<Car> cars;

    private RacingResult(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingResult getInstance(List<Car> cars) {
        return new RacingResult(cars);
    }

    public String getWinner() {
        Collections.sort(cars, (car1, car2) -> car2.position - car1.position);
        Car firstWinner = cars.get(0);

        String winners = cars.stream()
            .filter(car -> car.isSamePosition(firstWinner))
            .map(Car::getName)
            .collect(Collectors.joining(DELIMITER));

        return winners;
    }

    public List<Car> getResult() {
        return this.cars;
    }
}
