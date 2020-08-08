package racingcar;

import java.util.*;

public class RacingGame {
    private final Cars cars;
    private final int numberOfTrials;

    private RacingGame(GameInputs args) {
        this.numberOfTrials = args.getNumberOfTrials();
        this.cars = Cars.createAllCars(args.getNameOfCars());
    }

    public GameResults start() {
        GameStepList steps = GameStepList.createSteps();

        steps.addStep(
                GameStep.createGameStep(
                    CarStateList.makeCarStateList(cars.getStates())
                )
        );

        for (int step = 0; step < this.numberOfTrials; step++) {
            cars.moveCars();

            steps.addStep(
                    GameStep.createGameStep(
                            CarStateList.makeCarStateList(cars.getStates())
                    )
            );
        }

        List<String> winners = this.cars.findByMaxPosition();

        return GameResults.createResult(steps, winners);
    }

    public static RacingGame createGame(GameInputs args) {
        return new RacingGame(args);
    }
}
