package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(String carNames) {
        this(createCars(parseCarNames(carNames)));
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private static List<String> parseCarNames(String carNameInput) {
        return Arrays.asList(carNameInput.split(","));
    }

    private static List<Car> createCars(List<String> parsedCarNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : parsedCarNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.tryMoveForward(new RandomNumber());
        }
    }

    public List<String> status() {
        List<String> carsStatus = new ArrayList<>();
        for (Car car : cars) {
            carsStatus.add(car.toString());
        }

        return carsStatus;
    }


    public Position getMaxPosition() {
        Position maxPosition = new Position(0);
        for (Car car : cars) {
            maxPosition = car.max(maxPosition);
        }

        return maxPosition;
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        Position maxPosition = getMaxPosition();

        for (Car car : cars) {
            if (car.isMaxPosition(maxPosition)) {
                winners.add(car.name());
            }
        }

        return winners;
    }
}

