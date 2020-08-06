package racingcar;

public class RacingGame {
    private final Cars cars;
    private final int numberOfTrials;

    private RacingGame(GameInputs args) {
        this.numberOfTrials = args.getNumberOfTrials();
        this.cars = Cars.createAllCars(args.getNumberOfCars());
    }

    public GameResults start() {
        GameResults result = GameResults.createResult();

        result.addStep(cars.getPositions());

        for (int step = 0; step < this.numberOfTrials; step++) {
            cars.moveCars();
            result.addStep(cars.getPositions());
        }

        return result;
    }

    public static RacingGame createGame(GameInputs args) {
        return new RacingGame(args);
    }
}
