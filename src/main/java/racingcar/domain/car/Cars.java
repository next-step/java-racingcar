package racingcar.domain.car;

import racingcar.strategy.raceStrategy.DoOneForward;
import racingcar.strategy.condition.OneOrZeroForwardCondition;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public int getMaxPosition() {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .map(Car::getPosition)
                .orElseThrow(IllegalArgumentException::new);
    }

    public void moveCars() {
        cars.forEach(o -> o.move(new OneOrZeroForwardCondition(), new DoOneForward()));
    }

    public List<Car> filterWinners() {
        return cars.stream( )
                .filter(car -> car.isMaxPosition(getMaxPosition( )))
                .collect(Collectors.toList( ));
    }

    public List<Car> getCars() {
        return cars;
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
