package racingcar.racing;

import java.util.List;
import racingcar.domain.RacingPlaying;
import racingcar.ui.RacingCarInput;

public class RacingGame {
    List<String> carNameList;
    int raceCount;

    public void playRacingGame() {
        inputAll();
        RacingPlaying racingPlaying = new RacingPlaying(carNameList);
        String gameStatus = racingPlaying.getGameStatus(raceCount, carNameList);
        List<String> gameWinner = racingPlaying.getGameWinner();
        System.out.println(gameStatus);
        System.out.print("최종 우승자: " + String.join(", ", gameWinner));
    }

    private void inputAll() {
        carNameList = RacingCarInput.getCarName();
        raceCount = RacingCarInput.getRaceCount();
    }

}
