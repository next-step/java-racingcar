package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racingcar.model.Car;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private static final String TRY_COUNT_LESS_THAN_ZERO = "[ERROR] 시도 횟수는 1회 이상이어야 합니다.";
    private static final String GAME_RESULT_MESSAGE = "출력결과";
    private static final int MINIMUM_TRY_COUNT = 1;
    private static final int RANDOM_BOUND_VALUE=9;
    private List<Car> cars = new ArrayList<>();

    public void play() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        String[] carNames = inputView.inputCarNames();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        int tryCount = inputView.inputTryCount();
        validateTryCount(tryCount);

        System.out.println(GAME_RESULT_MESSAGE);
        for (int i = 0; i < tryCount; i++) {
            moveForwardByCarsSize();
            outputView.printResult(cars);
        }
        Winner winner = new Winner(cars);
        outputView.printWinner(winner.findWinner());
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < MINIMUM_TRY_COUNT) {
            throw new IllegalArgumentException(TRY_COUNT_LESS_THAN_ZERO);
        }
    }

    public void moveForwardByCarsSize() {
        Random random = new Random();
        for (Car car : cars) {
            int moveOrNot = random.nextInt(RANDOM_BOUND_VALUE);
            car.moveForward(moveOrNot);
        }
    }

}
