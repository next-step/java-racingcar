package step4.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Cars {

    private List<Car> cars = new ArrayList<>();
    private final CarMovingStrategy carMovingStrategy = new CarMovingStrategy();

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Cars(String  carNames) {
        registerCar(carNames);
    }

    private void registerCar(String carNames) {
        cars = Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(toList());
    }

    public String getWinnerNames() {
        return getWinners().stream()
                .map(Car::getName)
                .collect(joining(", "));
    }

    private List<Car> getWinners() {
        return cars.stream()
                .filter(car -> car.isWinner(getMaxPosition()))
                .collect(toList());
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for(Car car : cars) {
           maxPosition = car.max(maxPosition);
        }
        return maxPosition;
    }

    public void moveOfCars() {
        cars.forEach(s -> s.move(carMovingStrategy));
    }
}
