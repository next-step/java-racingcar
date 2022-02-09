package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingGame;
import racingcar.domain.Winners;
import racingcar.view.RacingCarInput;
import racingcar.view.RacingCarOutput;

public class GameLauncher {

    private List<String> carNameLists;
    private int raceCount;
    private List<RacingCar> racingCarLists;
    private RacingGame racingGame;

    public void start() {
        inputAll();
        racingGameProcess();
        winnerProcess();
    }

    private void racingGameProcess() {
        racingGame = new RacingGame(carNameLists, raceCount);
        racingGame.runRace();
        racingCarLists = racingGame.getRacingCarLists();
        RacingCarOutput.printGameScore();
    }

    private void winnerProcess() {
        Winners winners = new Winners(racingCarLists);
        List<String> gameWinner = winners.getRacingWinnerLists();
        RacingCarOutput.printWinnersResult(gameWinner);
    }

    private void inputAll() {
        carNameLists = RacingCarInput.getCarName();
        raceCount = RacingCarInput.getRaceCount();
    }

}
