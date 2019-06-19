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
        return new Cars(createCars(carNames, RacingGameRandomUtils::isMove));
    }

    public static Cars newCars(List<CarName> carNames, MoveStrategy moveStrategy) {
        return new Cars(createCars(carNames, moveStrategy));
    }

    private static List<Car> createCars(List<CarName> carNames, MoveStrategy moveStrategy) {
        int numberOfCar = carNames.size();
        if (numberOfCar == 0) {
            throw new IllegalArgumentException("경주 자동차는 1대 이상 추가해야 합니다.");
        }

        List<Car> newCars = new ArrayList<>();
        for (int carNo = 0; carNo < numberOfCar; carNo++) {
            newCars.add(new Car(carNo, carNames.get(carNo), moveStrategy));
        }
        return newCars;
    }

    public Cars startTurn() {
        List<Car> newCars = new ArrayList<>();
        for (Car car : this.getCars()) {
            Car movedCar = car.move();
            newCars.add(movedCar);
        }

        return new Cars(newCars);
    }

    public List<Car> getCars() {
        return cars.stream()
                   .map(Car::new)
                   .collect(Collectors.toList());
    }

}
