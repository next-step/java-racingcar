package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.strategy.MovingStrategy;
import racingcar.strategy.RandomValueStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarGameApplication {
    public static void main(String[] args) {
        Car car = new Car();
        car.move(getRandomValueStrategy());

        int carCount = InputView.inputCarCount();
        int tryCount = InputView.inputTryCount();
        System.out.println("carCount = " + carCount);
        System.out.println("tryCount = " + tryCount);

        Cars carRacing = new Cars(carCount);

        ResultView.printResultMessage();

        for(int i = 0; i < carCount; i++) {
            carRacing.move(tryCount, getRandomValueStrategy());
        }
    }

    public static MovingStrategy getRandomValueStrategy() {
        return new RandomValueStrategy();
    }
}
