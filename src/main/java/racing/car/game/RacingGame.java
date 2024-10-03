package racing.car.game;

import racing.car.car.Car;
import racing.car.random.GenerateRandom;
import racing.car.ui.InputView;
import racing.car.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame implements Game {

    private static final Scanner scanner = new Scanner(System.in);
    private static final InputView INPUT_VIEW = new InputView(scanner);
    private static final ResultView RESULT_VIEW = new ResultView();
    private static final String INVALID_CAR_COUNT_MESSAGE = "게임을 진행하려면 자동차가 최소 2대 있어야 합니다.";
    private static final String INVALID_TRY_COUNT_MESSAGE = "게임을 진행하려면 시도 횟수는 1 이상이어야 합니다.";
    private static final GenerateRandom GENERATE_RANDOM = new GenerateRandom();
    private int max = Integer.MIN_VALUE;

    @Override
    public void play() {
        INPUT_VIEW.carQuestion();
        String[] carNames = INPUT_VIEW.inputCar();

        List<Car> cars = new ArrayList<>();

        initializeCars(carNames, cars);

        INPUT_VIEW.tryQuestion();
        int tryCount = validateTryCount(INPUT_VIEW.inputTry());

        for (int i = 0; i < tryCount; i++) {
            simulateRaceRound(cars);
        }
        max(cars);
        RESULT_VIEW.outputWinnerView(max, cars);
    }

    public void simulateRaceRound(List<Car> cars) {
        for (Car car : cars) {
            car.move(GENERATE_RANDOM.random());
        }
        RESULT_VIEW.outputView(cars);
    }

    public void max(List<Car> cars) {
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }
    }

    public void initializeCars(String[] carNames, List<Car> cars) {
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
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
