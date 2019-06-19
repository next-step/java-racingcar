package step2.game.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import step2.game.util.RacingGameRandomUtils;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars newCars(List<CarName> carNames) {
        int numberOfCar = carNames.size();
        assertCarNames(numberOfCar);

        List<Car> newCars = new ArrayList<>();
        for (int carNo = 0; carNo < numberOfCar; carNo++) {
            newCars.add(new Car(carNo, carNames.get(carNo)));
        }

        return new Cars(newCars);
    }

    public Cars startTurn() {
        List<Car> newCars = new ArrayList<>();
        for (Car car : this.getCars()) {
            Car movedCar = car.move(RacingGameRandomUtils::isMove);
            newCars.add(movedCar);
        }

        return new Cars(newCars);
    }

    public List<Car> getCars() {
        return cars.stream()
                   .map(Car::new)
                   .collect(Collectors.toList());
    }

    private static void assertCarNames(final int numberOfCar) {
        if (numberOfCar == 0) {
            throw new IllegalArgumentException("경주 자동차는 1대 이상 추가해야 합니다.");
        }
    }

}
