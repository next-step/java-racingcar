package racingGame.testFactory;

import racingGame.domain.Car;
import racingGame.factory.CarFactory;
import racingGame.racingRule.FowardRule;
import racingGame.domain.WinnerCar;

public class WinningCarFactory extends CarFactory {
    private final FowardRule fowardRule = new FowardRule();

    @Override
    public Car createCar(String carName) {
        return new WinnerCar(carName, fowardRule);
    }
}
