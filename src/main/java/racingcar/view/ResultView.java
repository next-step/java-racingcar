package racingcar.view;

import java.util.List;
import racingcar.domain.GameStatus;
import racingcar.domain.RacingCar;

public class ResultView {

    private static final int GAME_COUNT_LAST = 0;

    public String getGameStatus(int raceCount, List<RacingCar> racingCarLists) {
        StringBuilder currentResult = new StringBuilder();
        while (raceCount > GAME_COUNT_LAST) {
            currentResult.append(new GameStatus().moveForwardAll(racingCarLists));
            raceCount--;
        }
        return currentResult.toString();
    }

}
