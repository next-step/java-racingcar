package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingCar;
import racingcar.generator.RandomGenerator;
import racingcar.strategy.RandomStrategy;
import racingcar.ui.InputView;

public class RacingCarService {

    public static void gameStart() {
        RacingCar racingCar = new RacingCar(
                getCars(InputView.inputValidatedNumberOfCar()),
                InputView.inputValidatedNumberOfAttempts()
        );
        racingCar.racing(createRandomStrategy());
    }

    public static Car[] getCars(int car) {
        Car[] cars = new Car[car];
        for (int i = 0; i < car; i++) {
            cars[i] = new Car();
        }
        return cars;
    }

    private static RandomStrategy createRandomStrategy() {
        return new RandomStrategy(new RandomGenerator());
    }

}
