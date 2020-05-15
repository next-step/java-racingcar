package racinggame;

import racinggame.domain.RacingGame;
import racinggame.domain.RandomEngine;
import racinggame.domain.result.RacingGameResult;
import racinggame.dto.RacingGameInfo;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class RacingGameApplication {

    public static void main(String[] args) {
        String listOfRacingCars = InputView.askListOfRacingCars();
        String numberOfAttempt = InputView.askNumberOfAttempt();

        RacingGameInfo racingGameInfo = new RacingGameInfo(listOfRacingCars, numberOfAttempt);
        RacingGame racingGame = new RacingGame(racingGameInfo);

        RacingGameResult racingGameResult = racingGame.raceWith(new RandomEngine());

        OutputView.announceResult(racingGameResult);
    }
}
