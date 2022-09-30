package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameFactory {

    public static RacingGame make(RacingGameCondition condition) {
        List<RacingCar> racingCars = makeRacingCars(condition.getRacingCarNames());
        return new RacingGame(racingCars, condition.getGameTurnCount());
    }

    private static List<RacingCar> makeRacingCars(List<String> racingCarNames) {
        return racingCarNames.stream()
                             .map(RacingCar::new)
                             .collect(Collectors.toUnmodifiableList());
    }
}
