package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.view.RacingCarInput;
import racingcar.view.RacingCarOutput;

public class GameLauncher {
    List<String> carNameList;
    int raceCount;
    public void start() {
        inputAll();
        RacingGame racingGame = new RacingGame(carNameList);
        String gameStatus = racingGame.getGameStatus(raceCount);
        List<String> gameWinner = racingGame.getGameWinner();
        System.out.println(gameStatus);
        System.out.print(RacingCarOutput.SYSTEM_MESSAGE_FINAL_WINNER + String.join(", ", gameWinner));
    }

    public void inputAll() {
        carNameList = RacingCarInput.getCarName();
        raceCount = RacingCarInput.getRaceCount();
    }
}
