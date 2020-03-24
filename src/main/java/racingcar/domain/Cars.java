package racingcar.domain;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static racingcar.domain.RacingGameConstant.NO_WINNER;

public class Cars {
    private final List<Car> cars;

    Cars(Collection<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(toList());
    }

    Cars(List<Car> cars) {
        this.cars = cars;
    }

    Cars moveAllCar(MoveStrategy moveStrategy) {
        List<Car> movedCars = cars.stream()
                .map(car -> car.move(moveStrategy.isMove()))
                .collect(toList());

        return new Cars(movedCars);
    }

    boolean hasNextCar(int index) {
        return cars.size() != index;
    }

    Car get(int index) {
        return new Car(cars.get(index));
    }

    public List<String> getWinners() {
        Car winner = cars.stream()
                .sorted(comparing(Car::getPosition).reversed())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_WINNER));

        return cars.stream()
                .filter(car -> car.isSamePosition(winner))
                .collect(toList())
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}
