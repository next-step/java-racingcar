package service;

import java.util.List;
import java.util.stream.Collectors;

import domain.Car;
import view.RacingCarView;

public class RacingCarService {
    public void startRacing(List<String> carNames, int targetDistance) {
        // make cars
        List<Car> cars = makeCars(carNames);

        // move cars
        RacingCarView.printStartRacing();
        moveCars(cars, targetDistance);

        // print winner
        RacingCarView.printResult(getWinnerNames(cars));
    }

    private String getWinnerNames(List<Car> cars) {
        int maxDistance = getMaxDistance(cars);
        List<String> winners = getWinners(cars, maxDistance);

        return String.join(", ", winners);
    }

    private int getMaxDistance(List<Car> cars) {
        return cars.stream()
                .map(Car::getDistance)
                .max(Integer::compareTo)
                .get();
    }

    private List<String> getWinners(List<Car> cars, int maxDistance) {
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void printCars(List<Car> cars) {
        cars.stream()
                .forEach(car -> RacingCarView.printCar(car.getName(), car.getDistance()));
    }

    private List<Car> makeCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void moveCars(List<Car> cars, int targetDistance) {
        for (int i = 0; i < targetDistance; i++) {
            moveCars(cars);
            printCars(cars);
            RacingCarView.printNewLine();
        }
    }

    private void moveCars(List<Car> cars) {
        cars.stream()
                .forEach(Car::move);
    }

}
