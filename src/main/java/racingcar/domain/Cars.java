package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

    private static final String DELIMITER = ",";
    private final List<Car> cars;

    public Cars(final String inputCarNames, final DriveWay driveWay) {
        this.cars = new ArrayList<>();
        String[] carNames = inputCarNames.split(DELIMITER);
        for (String carName : carNames) {
            cars.add(new Car(carName, driveWay));
        }
    }

    public void race() {
        for (Car car : cars) {
            car.race();
        }
    }

    List<Car> findWinners() {
        final int maxDistance = findMaxDistance();
        return cars.stream().filter(car -> car.isWinner(maxDistance)).collect(Collectors.toList());
    }

    private int findMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = car.findMaxDistance(maxDistance);
        }

        return maxDistance;
    }

    List<Car> get() {
        return this.cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
