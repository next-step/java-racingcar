package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.strategy.MovingStrategy;
import racingcar.strategy.RandomValueStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarGameApplication {
    public static void main(String[] args) {
        int carCount = InputView.inputCarCount();
        int tryCount = InputView.inputTryCount();
        ResultView.printResultMessage();
        Cars cars = new Cars(carCount);
        List<Car> values = cars.racing(tryCount, getRandomValueStrategy());
        for (Car value : values) {
            ResultView.printPositionMark(value.getPosition());
        }
    }

    public static MovingStrategy getRandomValueStrategy() {
        return new RandomValueStrategy();
    }
}
