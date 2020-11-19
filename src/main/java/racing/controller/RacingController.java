package racing.controller;

import racing.domain.RacingGame;
import racing.domain.RacingRound;
import racing.domain.RacingWinner;
import racing.ui.ResultView;

public class RacingController {

    public void race(String[] names, int roundCount) {
        RacingGame racingGame = new RacingGame(roundCount, names);
        RacingRound racingRound = racingGame.startRacing();
        RacingWinner racingWinner = new RacingWinner(racingRound);

        ResultView.output(racingRound, racingWinner);
    }
}
