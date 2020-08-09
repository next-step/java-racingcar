package controller;

import racingcar.model.RacingRound;
import racingcar.service.RacingGame;
import racingcar.view.InputValidater;

import java.util.List;

public class RacingController {

    private List<String> racingCarNames;
    private int racingRound;
    private RacingGame racingGame;

    public RacingController(String carNames, String round) {
        racingCarNames = InputValidater.validateCarNames(carNames);
        racingRound = InputValidater.validateRound(round);
        racingGame = new RacingGame(racingCarNames, racingRound);
    }

    public void startRace() {
        racingGame.start();
    }

    public List<RacingRound> getRacingResults() {
        return racingGame.getRoundResults();
    }

}
