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
                .max(Comparator.comparing(Car::getPosition))
                .map(Car::getPosition)
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


}
