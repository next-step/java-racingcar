package racinggame;

import racinggame.domain.DefaultEngine;
import racinggame.domain.RacingGame;
import racinggame.domain.RacingGameSnapshot;
import racinggame.view.InputView;
import racinggame.view.OutputView;
import racinggame.vo.RacingGameInfo;

import java.util.List;

public class RacingGameApplication {

    public static void main(String[] args) {
        String numberOfCar = InputView.askNumberOfCar();
        String numberOfAttempt = InputView.askAttemptOfMovement();

        RacingGameInfo racingGameInfo = new RacingGameInfo(numberOfCar, numberOfAttempt);
        RacingGame racingGame = new RacingGame(racingGameInfo);

        List<RacingGameSnapshot> racingGameSnapshots = racingGame.raceWith(new DefaultEngine());

        OutputView.announceResult(racingGameSnapshots);
    }
}
