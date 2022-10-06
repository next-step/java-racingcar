package racingGame.testFactory;

import racingGame.domain.Car;
import racingGame.factory.CarFactory;
import racingGame.domain.LoserCar;
import racingGame.racingRule.NotMoveRule;

public class LoserCarFactory extends CarFactory {
    private final NotMoveRule notMoveRule  = new NotMoveRule();

    @Override
    public Car createCar(String carName) {
        return new LoserCar(carName, notMoveRule);
    }
}
