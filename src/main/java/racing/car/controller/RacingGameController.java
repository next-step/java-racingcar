package racing.car.controller;

import racing.car.model.Cars;
import racing.car.random.GenerateRandom;
import racing.car.view.InputView;
import racing.car.view.ResultView;

import java.util.ArrayList;
import java.util.Scanner;

public class RacingGameController {

    private static final Scanner scanner = new Scanner(System.in);
    private static final InputView INPUT_VIEW = new InputView(scanner);
    private static final ResultView RESULT_VIEW = new ResultView();
    private static final String INVALID_CAR_COUNT_MESSAGE = "게임을 진행하려면 자동차가 최소 2대 있어야 합니다.";
    private static final String INVALID_TRY_COUNT_MESSAGE = "게임을 진행하려면 시도 횟수는 1 이상이어야 합니다.";


    public static void main(String[] args) {
        RacingGameController game = new RacingGameController();
        game.play();
    }

    public void play() {
        INPUT_VIEW.carQuestion();
        String[] carNames = INPUT_VIEW.inputCar();

        Cars cars = new Cars(new ArrayList<>());

        initializeCars(carNames, cars);

        INPUT_VIEW.tryQuestion();
        int tryCount = validateTryCount(INPUT_VIEW.inputTry());

        for (int i = 0; i < tryCount; i++) {
            simulateRaceRound(cars);
        }

        RESULT_VIEW.outputWinnerView(cars.findWinner(max(cars)));
    }

    public void simulateRaceRound(Cars cars) {
        cars.move(new GenerateRandom());
        RESULT_VIEW.outputView(cars);
    }

    public int max(Cars cars) {
        return cars.getMaxPosition();
    }

    public void initializeCars(String[] carNames, Cars cars) {
        cars.addCars(carNames);
    }

    public int validateCarCount(int carCount) {
        if (carCount < 2) {
            throw new RuntimeException(INVALID_CAR_COUNT_MESSAGE);
        }
        return carCount;
    }

    public int validateTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new RuntimeException(INVALID_TRY_COUNT_MESSAGE);
        }
        return tryCount;
    }

}
