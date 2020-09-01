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


    public List<Car> getCars() {
        return cars;
    }

    public WinnerCars findWinnerCars() {
        return new WinnerCars(filterWinners(getMaxPosition()));
    }

    public int getMaxPosition() {
        return cars.stream( )
                .mapToInt(Car::getPosition)
                .max( )
                .orElseThrow(IllegalArgumentException::new);
    }

    public void moveCars() {
        this.cars.forEach(car
                -> car.move(new OneOrZeroForwardCondition(), new DoOneForward()));
    }

    public List<Car> filterWinners(int maxPosition) {
        return cars.stream()
                .filter(car -> car.equalToPosition(maxPosition))
                .collect(Collectors.toList());
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
