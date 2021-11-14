package racingcar.domain;

import racingcar.domain.value.CarName;
import racingcar.domain.value.Position;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<RacingCar> carList;

    private RacingCars(List<RacingCar> carList) {

        this.carList = carList;
    }

    public static RacingCars create(List<RacingCar> carList) {

        return new RacingCars(carList);
    }

    public List<RacingCar> getCars() {

        return carList;
    }

    public String getVictoryUsers() {
        Position maxPosition = getMaxPosition();
        return carList.stream()
                .filter(car -> car.isWinner(maxPosition))
                .map(RacingCar::getCarName)
                .map(CarName::getName)
                .collect(Collectors.joining(","));
    }

    private Position getMaxPosition() {
        Position maxPosition = Position.create(0);
        for (RacingCar car : carList) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }
}
