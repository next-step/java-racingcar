package racingcar;

import java.util.*;

public class RacingGame {
    private final Cars cars;
    private final int numberOfTrials;

    private RacingGame(GameInputs args) {
        this.numberOfTrials = args.getNumberOfTrials();
        this.cars = Cars.createAllCars(args.getNameOfCars());
    }

    public GameResults start() throws NoSuchElementException {
        List<Map<String, Integer>> steps = new ArrayList<>();

        steps.add(cars.getState());

        for (int step = 0; step < this.numberOfTrials; step++) {
            cars.moveCars();
            steps.add(cars.getState());
        }

        int max = this.cars.getMaxPosition();
        List<String> winners = this.cars.find(max);

        return GameResults.createResult(steps, winners);
    }

    public static RacingGame createGame(GameInputs args) {
        return new RacingGame(args);
    }
}
