package racingCar.domain;

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

    public List<Car> getCarGroup() {
        return carGroup;
    }
}
