package racinggame.racingcar;

import java.util.List;
import java.util.Map;

public class Race {
    private final RacingCars racingCars;

    private Race(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public static Race create(MoveStrategy moveStrategy, List<String> carNames) {
        RacingCars racingcars = RacingCars.create(moveStrategy, carNames);
        return new Race(racingcars);
    }

    public void proceedRound() {
        racingCars.moveAll();
    }

    public Map<String, Integer> collectResults() {
        return racingCars.getCarsInfo();
    }
}
