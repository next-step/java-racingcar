package racingcar.controller;

import java.util.List;

import racingcar.domain.RacingPlaying;
import racingcar.view.RacingCarInput;
import racingcar.view.RacingCarOutput;

public class RacingGame {
    List<String> carNameList;
    int raceCount;

    public void playRacingGame() {
        inputAll();
        RacingPlaying racingPlaying = new RacingPlaying(carNameList);
        String gameStatus = racingPlaying.getGameStatus(raceCount);
        List<String> gameWinner = racingPlaying.getGameWinner();
        System.out.println(gameStatus);
        System.out.print(RacingCarOutput.SYSTEM_MESSAGE_FINAL_WINNER + String.join(", ", gameWinner));
    }

    public void inputAll() {
        carNameList = RacingCarInput.getCarName();
        raceCount = RacingCarInput.getRaceCount();
    }

}
