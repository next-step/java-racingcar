package racinggame;

import racinggame.domain.RacingGame;
import racinggame.domain.RacingGameSnapshot;
import racinggame.domain.RandomEngine;
import racinggame.dto.RacingGameInfo;
import racinggame.view.InputView;
import racinggame.view.OutputView;

import java.util.List;

public class RacingGameApplication {

    public static void main(String[] args) {
        String numberOfCar = InputView.askNumberOfCar();
        String numberOfAttempt = InputView.askNumberOfAttempt();

        RacingGameInfo racingGameInfo = new RacingGameInfo(numberOfCar, numberOfAttempt);
        RacingGame racingGame = new RacingGame(racingGameInfo);

        List<RacingGameSnapshot> racingGameSnapshots = racingGame.raceWith(new RandomEngine());

        OutputView.printTrackOf(racingGameSnapshots);
    }
}
