package racing.core;

import racing.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    public static final int TOTAL_CASES = 10;
    public List<Car> cars;
    public int trials;

    public RacingGame(int numberOfCars, int numberOfTrials) {
        // ready
        this.cars = makeUpEntry(numberOfCars);
        this.trials = numberOfTrials;
    }

    public void run() {
        ResultView resultView = start();
        resultView.printResult();
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
