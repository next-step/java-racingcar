package racinggame.racingcar;

import java.util.List;

public class Race {
    private final RacingCars racingCars;

    private Race(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public static Race create(MoveStrategy moveStrategy, List<String> carNames) {
        RacingCars racingcars = RacingCars.create(moveStrategy, carNames);
        return new Race(racingcars);
    }

    public List<Integer> proceedRounds() {
        racingCars.moveAll();
        return racingCars.getCurrentPositionsRepresentation();
    }
}
