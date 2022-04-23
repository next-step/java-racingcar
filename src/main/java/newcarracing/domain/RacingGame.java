package newcarracing.domain;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    private static GameRule gameRule;

    public static RacingGame makeRacingGame(RuleCondition ruleCondition) {
        RacingGame racingGame = new RacingGame();
        gameRule = new GameRule();
        gameRule.setRuleCondition(ruleCondition);
        return racingGame;
    }

    public List<RacingCars> play(String[] carNames, int tryCount) throws CloneNotSupportedException {
        List<RacingCars> racingGameResults = new ArrayList<>();
        List<RacingCar> racingCars = initRacingCars(carNames);
        for (int i = 1; i <= tryCount; i++) {
            racingGameResults.add(racing(racingCars));
        }
        return racingGameResults;
    }

    private List<RacingCar> initRacingCars(String[] carNames) {
        return Arrays.stream(carNames).map(RacingCar::new).collect(Collectors.toList());
    }

    private RacingCars racing(List<RacingCar> cars) throws CloneNotSupportedException {
        cars.forEach(car -> car.moveForward(gameRule));
        return new RacingCars(cars);
    }
}
