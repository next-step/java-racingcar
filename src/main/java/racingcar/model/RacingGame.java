package racingcar.model;

import racingcar.view.ResultView;

public class RacingGame {
    private static final MovableStrategy movableStrategy = new RandomMovableStrategy();

    private RacingGame() {
    }

    public static void start(RacingCars racingCars, Round round) {
        while (round.checkRound()) {
            racingCars.move(movableStrategy);
            ResultView.printStatus(racingCars);
            round = round.decrease();
        }
        ResultView.printWinner(racingCars);
    }

}
