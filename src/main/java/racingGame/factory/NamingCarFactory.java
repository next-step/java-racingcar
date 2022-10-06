package racingGame.factory;

import racingGame.domain.Car;
import racingGame.domain.NamingCar;
import racingGame.racingRule.RacingRule;
import racingGame.racingRule.RacingRuleDefault;

public class NamingCarFactory extends CarFactory {
    private final RacingRule racingRule = new RacingRuleDefault();

    @Override
    public Car createCar(String carName) {
        return new NamingCar(carName, racingRule);
    }
}
