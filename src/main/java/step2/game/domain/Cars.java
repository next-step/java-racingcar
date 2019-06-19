package step2.game.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars newCars(int numberOfCar) {
        return new Cars(createCars(numberOfCar, new DefaultCarFactoryImpl(), new DefaultMoveStrategy()));
    }

    public static Cars newCars(int numberOfCar, MoveStrategy moveStrategy) {
        return new Cars(createCars(numberOfCar, new DefaultCarFactoryImpl(), moveStrategy));
    }

    public static Cars newCars(int numberOfCar, CarFactory carFactory) {
        return new Cars(createCars(numberOfCar, carFactory, new DefaultMoveStrategy()));
    }

    public static Cars newCars(int numberOfCar, CarFactory carFactory, MoveStrategy moveStrategy) {
        return new Cars(createCars(numberOfCar, carFactory, moveStrategy));
    }

    private static List<Car> createCars(int numberOfCar, CarFactory carFactory, MoveStrategy moveStrategy) {
        if (numberOfCar == 0) {
            throw new IllegalArgumentException("경주 자동차는 1대 이상 추가해야 합니다. Invalid Parameter : " + numberOfCar);
        }

        List<Car> newCars = new ArrayList<>();
        for (int carNo = 0; carNo < numberOfCar; carNo++) {
            newCars.add(carFactory.createCar(carNo, moveStrategy));
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
