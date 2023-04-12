package racing.utils;

import racing.domain.RacingCar;
import racing.domain.RacingGame;
import racing.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameCreateUtil {
    public static RacingGame createGameWithStrategy(List<String> nameOfCars, MoveStrategy moveStrategy) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String name : nameOfCars) {
            racingCars.add(new RacingCar(name, moveStrategy));
        }
        return new RacingGame(racingCars);
    }
}
