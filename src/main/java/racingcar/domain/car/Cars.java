package racingcar.domain.car;

import racingcar.strategy.raceStrategy.DoOneForward;
import racingcar.strategy.condition.OneOrZeroForwardCondition;

import java.util.*;
import java.util.stream.Collectors;

import static racingcar.utils.Constants.WINNER_CAR_NAMES_DELIMITER;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaxPosition() {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .map(Car::getPosition)
                .orElseThrow(IllegalArgumentException::new);
    }

    public Map<String, Integer> toRacingRecord() {
        return cars.stream()
                .collect(Collectors.toMap(
                        Car::getCarName,
                        Car::getPosition,
                        (first, second) -> first,
                        LinkedHashMap::new));
    }

    public void moveCars() {
        cars.forEach(car
                -> car.move(new OneOrZeroForwardCondition(), new DoOneForward()));
    }

    public List<Car> filterWinners() {
        return cars.stream( )
                .filter(car -> car.isMaxPosition(getMaxPosition( )))
                .collect(Collectors.toList( ));
    }

    public String findWinnersNames() {
        return filterWinners().stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(WINNER_CAR_NAMES_DELIMITER));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
