package newcarracing;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    private GameRule gameRule;

    public RacingGame(RuleCondition ruleCondition) {
        gameRule = new GameRule();
        gameRule.setRuleCondition(ruleCondition);
    }

    public List<RacingGameResult> play(String[] carNames, int tryCount) throws CloneNotSupportedException {
        List<RacingGameResult> racingGameResults = new ArrayList<>();
        List<RacingCar> racingCars = initRacingCars(carNames);
        for (int i = 1; i <= tryCount; i++) {
            racingGameResults.add(racing(racingCars));
        }
        return racingGameResults;
    }

    private List<RacingCar> initRacingCars(String[] carNames) {
        return Arrays.stream(carNames).map(RacingCar::new).collect(Collectors.toList());
    }

    private RacingGameResult racing(List<RacingCar> cars) throws CloneNotSupportedException {
        cars.forEach(car -> car.moveForward(gameRule));
        return new RacingGameResult(cars);
    }
}
