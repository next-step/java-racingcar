package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        validateNoDuplicateNames(carNames);
        this.cars = createCars(carNames);
    }

    private static void validateNoDuplicateNames(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>();
        for (String carName : carNames) {
            addUniqueName(uniqueNames, carName);
        }
    }

    private static void addUniqueName(Set<String> uniqueNames, String carName) {
        if (!uniqueNames.add(carName)) {
            throw new IllegalArgumentException("duplicate name is not allowed [" + carName + "]");
        }
    }

    private static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public void move(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }

    public List<CarStatus> getStatuses() {
        List<CarStatus> carStatuses = new ArrayList<>();
        for (Car car : cars) {
            carStatuses.add(car.toCarStatus());
        }
        return carStatuses;
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = collectWinner(winners, car, maxPosition);
        }
        return winners;
    }

    private static int collectWinner(List<String> winners, Car car, int maxPosition) {
        int position = car.getPosition();
        if (position > maxPosition) {
            winners.clear();
        }
        if (position >= maxPosition) {
            winners.add(car.getName());
        }
        return Math.max(position, maxPosition);
    }
}
