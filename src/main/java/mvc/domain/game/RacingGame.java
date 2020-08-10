package mvc.domain.game;


import mvc.domain.car.Cars;
import mvc.domain.dto.GameSteps;
import mvc.domain.dto.StateOfCarsList;
import mvc.domain.dto.GameInputs;
import mvc.domain.dto.GameResults;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final int numberOfTrials;

    private RacingGame(GameInputs args) {
        this.numberOfTrials = args.getNumberOfTrials();
        this.cars = Cars.createAllCars(args.getNameOfCars());
    }

    public GameResults startGame() {
        GameSteps steps = GameSteps.createSteps();

        steps.addStep(
                StateOfCarsList.makeCarStateList(this.cars.getStates())
        );

        for (int step = 0; step < this.numberOfTrials; step++) {
            cars.moveCars();

            steps.addStep(
                    StateOfCarsList.makeCarStateList(this.cars.getStates())
            );
        }

        List<String> winners = this.cars.findByMaxPosition();

        return GameResults.createResult(steps, winners);
    }

    public static RacingGame createGame(GameInputs args) {
        return new RacingGame(args);
    }
}
