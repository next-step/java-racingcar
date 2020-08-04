package racingcar;

import java.util.Random;

public class RacingGame {
    private final Random generator;
    private final Car[] cars;
    private int numberOfTrials;

    private RacingGame(UserArguments args) {
        this.numberOfTrials = args.getNumberOfTrials();
        this.generator = new Random();
        this.cars = Car.createAllCars(args.getNumberOfCars());
    }

    public GameResults start() {
        GameResults result = GameResults.createResult();

        while (hasNext()) {
            result.addStep(Car.cloneAllCars(this.cars));

            moveCars();
            nextStep();
        }

        return result;
    }

    private boolean hasNext() {
        return (this.numberOfTrials > 0);
    }

    private void nextStep() {
        this.numberOfTrials--;
    }

    private void moveCars() {
        for (Car car : this.cars) {
            int fuel = this.generator.nextInt(10);

            car.move(fuel);
        }
    }

    public static RacingGame createGame(UserArguments args) {
        return new RacingGame(args);
    }
}
