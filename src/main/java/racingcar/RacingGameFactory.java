package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGameFactory {

    public static RacingGame make(RacingGameCondition condition) {
        List<RacingCar> racingCars = makeRacingCars(condition.getRacingCarCount());
        return new RacingGame(racingCars, condition.getGameTurnCount());
    }

    private static List<RacingCar> makeRacingCars(int amount) {
        List<RacingCar> racingCars = new ArrayList<>(amount);

        for (int i = 0; i < amount; i++) {
            racingCars.add(new RacingCar());
        }

        return racingCars;
    }
}
