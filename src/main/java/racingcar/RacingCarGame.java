package racingcar;

import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.model.CarManager;
import racingcar.model.Racing;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarGame {
    public static void main(String[] args) {
        start();
    }

    public static void start() {

        Racing racing = new Racing();

        List<Car> cars = CarFactory.createCars(InputView.inputCarName());

        CarManager carManager = new CarManager(cars);

        int gameRound = InputView.inputGameRound();

        for (int i = 0; i < gameRound; i++) {
            racing.start(carManager.getCars());
        }

        ResultView.printWinner(carManager.findWinner());
    }

}