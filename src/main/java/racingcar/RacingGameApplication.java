package racingcar;

import racingcar.car.Car;
import racingcar.car.CarFactory;
import racingcar.car.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingGameApplication {

    public static void main(String[] args) {
        int numberOfCars = InputView.getNumberOfCars();
        int tryCount = InputView.getTryCount();

        List<Car> cars = CarFactory.create(numberOfCars);
        RacingGame racingGame = new RacingGame(cars);

        ResultView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            racingGame.race();
            ResultView.show(racingGame.getCars());
        }
    }

}
