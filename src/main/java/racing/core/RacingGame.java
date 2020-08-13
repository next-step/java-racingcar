package racing.core;

import racing.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    public static final int TOTAL_CASES = 10;
    public static final String NEW_LINE = "\n";
    public List<Car> cars;
    public int trials;

    public RacingGame(int numberOfCars, int numberOfTrials) {
        // ready
        this.cars = makeUpEntry(numberOfCars);
        this.trials = numberOfTrials;
    }

    public ResultView run(Random random) {
        String board = "";
        for (int i = 0; i < trials; i++) {
            board += cars.stream()
                    .map(car -> car.move(random.nextInt(TOTAL_CASES)) + NEW_LINE)
                    .reduce("", (trial, track) -> trial += track) + NEW_LINE;
        }
        return new ResultView(board);
    }

    private List<Car> makeUpEntry(int numberOfCars) {
        List<Car> cars = new ArrayList<>(numberOfCars);
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
