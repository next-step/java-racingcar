package racingcar;

import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarGame {

    public static final String INVALID_INPUT_MSG = "invalid input ";

    public static void main(String[] args) {

        int carCount = InputView.showCarCountInput();
        checkValidInput(carCount);
        int tryCount = InputView.showTryCountInput();
        checkValidInput(tryCount);

        List<Car> cars = CarManager.prepareCar(carCount);
        startGame(cars, tryCount);
    }

    private static void checkValidInput(int num) {
        if (num <= 0) {
            System.out.println(INVALID_INPUT_MSG + num);
            System.exit(0);
        }
    }

    private static void startGame(List<Car> cars, int tryCount) {
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            System.out.println("Round " + (i + 1));
            CarManager.moveCars(cars, new RandomMoveStrategy());
            OutputView.showCarsLocation(cars);
        }
    }
}