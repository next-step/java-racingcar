package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Winner;
import racingcar.util.RandomGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {

    private static final String TRY_COUNT_LESS_THAN_ZERO = "[ERROR] 시도 횟수는 1회 이상이어야 합니다.";
    private static final String GAME_RESULT_MESSAGE = "출력결과";
    private List<Car> cars = new ArrayList<>();
    public void play() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        String[] carNames = inputView.inputCarName();

        for (String carName: carNames) {
            cars.add(new Car(carName));
        }
        int tryCount = inputView.inputTryCount();
        validateTryCount(tryCount);

        System.out.println(GAME_RESULT_MESSAGE);
        for (int i = 0; i < tryCount; i++) {
            moveForwardByCount();
            outputView.printResult(cars);
            System.out.println();
        }
        Winner winner = new Winner(cars);
        outputView.printWinner(winner.getWinner());
    }

    private void validateTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException(TRY_COUNT_LESS_THAN_ZERO);
        }
    }

    public void moveForwardByCount() {
        for (Car car : cars) {
            RandomGenerator randomGenerator = new RandomGenerator();
            int moveOrNot = randomGenerator.generateRandomNumber();
            car.moveForward(moveOrNot);
        }
    }


}
