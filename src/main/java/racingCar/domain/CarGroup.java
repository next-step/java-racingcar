package racingCar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarGroup {
    private final List<Car> carGroup;

    public CarGroup(List<Car> carGroup) {
        this.carGroup = carGroup;
    }

    public static CarGroup from(List<String> playerGroup) {
        return new CarGroup(convertToPlayerGroup(playerGroup));
    }

    private static List<Car> convertToPlayerGroup(List<String> playerGroup) {
        return playerGroup.stream()
                .map(Car::from)
                .collect(Collectors.toUnmodifiableList());
    }

    public void move(MovementGenerator movementGenerator) {
        carGroup.forEach(car -> car.move(movementGenerator.generate()));
    }

    public WinnerGroup getWinnerGroup() {
        int maxDistance = getMaxDistance();
        return carGroup.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.collectingAndThen(Collectors.toList(), WinnerGroup::new));
    }

    private int getMaxDistance() {
        return carGroup.stream()
                .map(Car::getDistance)
                .max(Integer::compareTo)
                .orElse(Distance.DEFAULT_DISTANCE);
    }

    public List<Car> getCarGroup() {
        return Collections.unmodifiableList(carGroup);
    }
}
