package racing.car.game;

import racing.car.car.Car;
import racing.car.random.GenerateRandom;
import racing.car.random.Random;
import racing.car.ui.InputView;
import racing.car.ui.ResultView;

import java.util.Scanner;

public class RacingGame implements Game {

    private static final Scanner scanner = new Scanner(System.in);
    private static final InputView inputView = new InputView(scanner);
    private static final ResultView resultView = new ResultView();
    private static final Random random = new GenerateRandom();
    private static final String INVALID_CAR_COUNT_MESSAGE = "게임을 진행하려면 자동차가 최소 2대 있어야 합니다.";
    private static final String INVALID_TRY_COUNT_MESSAGE = "게임을 진행하려면 시도 횟수는 1 이상이어야 합니다.";

    @Override
    public void play() {
        inputView.carQuestion();
        int carCount = validateCarCount(inputView.input());

        Car[] cars = new Car[carCount];

        initializeCars(carCount, cars);

        inputView.tryQuestion();
        int tryCount = validateTryCount(inputView.input());

        for (int i = 0; i < tryCount; i++) {
            simulateRaceRound(cars);
        }

    }

    private static void simulateRaceRound(Car[] cars) {
        for (Car car : cars) {
            int speed = random.random();
            car.move(speed);
            resultView.outputView(car.getPosition());
        }
        System.out.println();
    }

    private static void initializeCars(int carCount, Car[] cars) {
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car();
        }
    }

    private static int validateCarCount(int carCount) {
        if (carCount < 2) {
            throw new RuntimeException(INVALID_CAR_COUNT_MESSAGE);
        }
        return carCount;
    }

    private static int validateTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new RuntimeException(INVALID_TRY_COUNT_MESSAGE);
        }
        return tryCount;
    }

}
