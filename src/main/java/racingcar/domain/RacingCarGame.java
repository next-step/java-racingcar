package racingcar.domain;

import racingcar.domain.strategyPattern.MoveStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCarGame {
    private List<RacingCar> carList;

    public RacingCarGame(int carCount) {
        this.carList = createCarList(carCount);
    }

    public static List<RacingCar> createCarList(int carCount) {
        return Stream.generate(RacingCar::new)
                .limit(carCount)
                .collect(Collectors.toList());
    }

    public List<RacingCar> playRoundsAndReturnCarList(MoveStrategy moveStrategy) {
        for (RacingCar car : carList) {
            if (moveStrategy.isMovable()) {
                car.moveForward(moveStrategy);
            }
        }
        return carList;
    }
}
