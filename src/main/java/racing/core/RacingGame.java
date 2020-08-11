package racing.core;

import racing.ui.InputView;
import racing.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    public static final int TOTAL_CASES = 10;
    public List<Car> cars;
    public int trials;

    public RacingGame() {
        InputView inputView = new InputView();
        // ready
        this.cars = howManyCars(inputView);
        this.trials = howManyTrials(inputView);
    }

    public void run() {
        ResultView resultView = start();
        resultView.printResult();
    }

    private List<Car> howManyCars(InputView inputView) {
        return makeUpEntry(inputView.getNumber("자동차 대수는 몇 대 인가요?"));
    }

    private int howManyTrials(InputView inputView) {
        return inputView.getNumber("시도할 회수는 몇 회 인가요?");
    }

    private List<Car> makeUpEntry(int numberOfCars) {
        List<Car> cars = new ArrayList<>(numberOfCars);
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    private ResultView start() {
        Random random = new Random();
        ResultView resultView = new ResultView();

        for (int i = 0; i < trials; i++) {
            cars.stream()
                    .forEach(car -> resultView.trace(car.move(random.nextInt(TOTAL_CASES))));
            resultView.nextTrial();
        }
        return resultView;
    }
}
