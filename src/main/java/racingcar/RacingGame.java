package racingcar;

import racingcar.common.RandomGenerator;

public class RacingGame {
    private static final int INPUT_RANGE = 10;
    private final Car[] cars;
    private final int numberOfTrials;

    private RacingGame(GameInputs args) {
        this.numberOfTrials = args.getNumberOfTrials();
        this.cars = Car.createAllCars(args.getNumberOfCars());
    }

    public GameResults start() {
        GameResults result = GameResults.createResult();

        for (int step = 0; step < this.numberOfTrials; ++step) {
            result.addStep(Car.getPositions(this.cars));
            moveCars();
        }

        return result;
    }

    private void moveCars() {
        for (Car car : this.cars) {
            int fuel = RandomGenerator.generateRandomInt(INPUT_RANGE);

            car.move(fuel);
        }
    }

    public static RacingGame createGame(GameInputs args) {
        return new RacingGame(args);
    }
}
