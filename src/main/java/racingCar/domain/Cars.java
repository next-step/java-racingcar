package racingCar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> playerGroup) {
        return new Cars(convertToPlayerGroup(playerGroup));
    }


    public void move(MovementGenerator movementGenerator) {
        for (Car car : cars) {
            boolean isMovable = movementGenerator.generate();
            if (isMovable) {
                car.move();
            }
        }
    }

    public List<Car> getWinnerGroup() {
        int maxDistance = getMaxDistance();
        return cars.stream()
                .filter(car -> car.isSameDistance(maxDistance))
                .collect(Collectors.toUnmodifiableList());
    }

    private static List<Car> convertToPlayerGroup(List<String> playerGroup) {
        return playerGroup.stream()
                .map(Car::from)
                .collect(Collectors.toUnmodifiableList());
    }

    private int getMaxDistance() {
        return cars.stream()
                .map(Car::getDistance)
                .max(Integer::compareTo)
                .orElse(Distance.DEFAULT_DISTANCE);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
