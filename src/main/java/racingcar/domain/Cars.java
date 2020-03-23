package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Cars {
    private final List<Car> cars;

    Cars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
        this.cars = cars;
    }

    Cars(List<Car> cars) {
        this.cars = cars;
    }

    Cars moveAllCar(MoveStrategy moveStrategy) {
        List<Car> movedCars = new ArrayList<>();
        for (Car car : cars) {
            Car movedCar = car.move(moveStrategy.isMove());
            movedCars.add(movedCar);
        }
        return new Cars(movedCars);
    }

    boolean hasNextCar(int index) {
        return cars.size() != index;
    }

    Car getCar(int index) {
        return new Car(cars.get(index));
    }

    public String getWinner() {
        Car winner = cars.stream()
                .reduce((car1, car2) -> car1.getPosition() > car2.getPosition() ? car1 : car2)
                .orElseThrow(() -> new IllegalArgumentException(RacingGameConstant.NO_WINNER));

        return cars.stream()
                .filter(car -> car.isSamePosition(winner))
                .collect(toList())
                .stream()
                .map(Car::getName)
                .collect(joining(","));
    }

    @Override
    public String toString() {
        return cars.toString();
    }
}
