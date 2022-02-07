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
        racingGame = new RacingGame(carNameLists);
        racingCarLists = racingGame.getRacingCarLists();
        RacingCarOutput.printGameScore(raceCount, racingCarLists);

        Winners winners = new Winners(racingCarLists);
        List<String> gameWinner = winners.getRacingWinnerLists();
        RacingCarOutput.printWinnersResult(gameWinner);
    }

    public void inputAll() {
        carNameLists = RacingCarInput.getCarName();
        raceCount = RacingCarInput.getRaceCount();
    }

}
