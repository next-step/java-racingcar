package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.domain.Winners;
import racingcar.view.RacingCarInput;
import racingcar.view.RacingCarOutput;

public class GameLauncher {
    List<String> carNameList;
    int raceCount;
    public void start() {
        inputAll();
        RacingGame racingGame = new RacingGame(carNameList);
        String gameStatus = racingGame.getGameStatus(raceCount);

        Winners winners = new Winners(racingGame.getRacingCarLists());
        List<String> gameWinner = winners.getRacingWinnerLists();

        RacingCarOutput.printGameScore(gameStatus);
        RacingCarOutput.printWinnersResult(gameWinner);
    }

    public void inputAll() {
        carNameList = RacingCarInput.getCarName();
        raceCount = RacingCarInput.getRaceCount();
    }
}
