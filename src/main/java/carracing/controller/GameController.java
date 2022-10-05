package carracing.controller;


import java.util.stream.IntStream;

import carracing.model.Cars;
import carracing.model.RandomMovableStrategy;
import carracing.view.OutputInterface;
import carracing.view.RacingCondition;

public class GameController {
    private final OutputInterface outputInterface;

    public GameController(OutputInterface outputInterface) {
        this.outputInterface = outputInterface;
    }

    public void play(RacingCondition racingCondition) {
        Cars cars = new Cars(racingCondition.carCount());
        IntStream.range(0, racingCondition.attemptCount()).forEach(notUsed -> doTry(cars));
    }

    private void doTry(Cars cars) {
        cars.goOrStop(new RandomMovableStrategy());
        cars.gatherMoveResults().forEach(outputInterface::showCurrentStatus);
    }
}