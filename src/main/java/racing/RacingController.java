package racing;

import racing.domain.RacingGame;
import racing.view.Input;

import static racing.domain.RacingGame.SEPARATOR;
import static racing.view.Output.*;

public class RacingController {
    public static void main(String[] args) {
        String carNames = Input.makeCarNames();
        String[] carNameArray = carNames.split(SEPARATOR);
        RacingGame racingGame = new RacingGame(carNameArray);
        int count = Input.makeGameRepeatCount();
        racingGame.repeatMoveCars(count);

        printNowDistance(racingGame.getCars());
        printWinMessage(racingGame.findWinner());
    }
}
