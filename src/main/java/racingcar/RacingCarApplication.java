package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingCar;
import racingcar.domain.RandomMoveStrategy;
import racingcar.util.RandomGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {

    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar(createCars(InputView.readCarCount()), InputView.readAttemptCount());
        OutputView.printResultMessage();
        OutputView.printRaceResult(racingCar.race(new RandomMoveStrategy(new RandomGenerator())));
    }

    private static Car[] createCars(int count) {
        Car[] cars = new Car[count];
        for (int i = 0; i < count; i++) {
            cars[i] = new Car();
        }
        return cars;
    }
}
