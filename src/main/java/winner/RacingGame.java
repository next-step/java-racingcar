package winner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-10-29 01:39
 */
public class RacingGame {
    public static void startCarRacingWinner() {
        CarRaceWinnerGame carRaceWinnerGame = new CarRaceWinnerGame(CarRaceInputView.inputCarName(), CarRaceInputView.inputGameRound());
        carRaceWinnerGame.play();
    }
}
