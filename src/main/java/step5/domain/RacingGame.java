package step5.domain;

import step5.strategy.MoveStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private RacingCars racingCars;
    private MoveStrategy moveStrategy;

    public RacingGame(List<String> carNames, MoveStrategy moveStrategy) {
        this.racingCars = new RacingCars(carNames.stream()
                .map(carName -> new Car(carName))
                .collect(Collectors.toList()));
        this.moveStrategy = moveStrategy;
    }

    public void play() {
        racingCars.moveableCheck(moveStrategy);
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }
}
