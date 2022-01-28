package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.util.RandomGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {

    private static final String TRY_COUNT_LESS_THAN_ZERO = "[ERROR] 시도 횟수는 1회 이상이어야 합니다.";
    private static final String GAME_RESULT_MESSAGE = "출력결과";

    public void play() {
        List<Car> cars = new ArrayList<>();
        InputView inputView = new InputView();

        String[] carNames = inputView.inputCarName();

        for (String carName: carNames) {
            cars.add(new Car(carName));
        }

        int tryCount = inputView.inputTryCount();
        validateTryCount(tryCount);

        for (int i = 0; i < tryCount; i++) {
            System.out.println(GAME_RESULT_MESSAGE);
            moveForwardByCount(cars);
        }

        checkWinner(cars);
    }

    private void validateTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException(TRY_COUNT_LESS_THAN_ZERO);
        }
    }

    public void moveForwardByCount(List<Car> cars) {
        OutputView outputView = new OutputView();
        for (Car car : cars) {
            RandomGenerator randomGenerator = new RandomGenerator();
            int moveOrNot = randomGenerator.generateRandomNumber();
            car.moveForward(moveOrNot);
            outputView.printResult(car.getCarName(), car.getPosition());
        }
        System.out.println();
    }

    public void checkWinner(List<Car> cars) {
        ArrayList<String> winnerList = new ArrayList<>();
        OutputView outputView = new OutputView();
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition().length() > maxPosition) {
                maxPosition = car.getPosition().length();

            }
        }
        for (Car car : cars) {
            if (car.getPosition().length() == maxPosition) {
                winnerList.add(car.getCarName());
            }
        }
        outputView.printWinner(winnerList);
    }
}
