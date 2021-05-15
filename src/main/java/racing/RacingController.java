package racing;

import racing.domain.RacingGame;

import static racing.domain.RacingGame.SEPARATOR;
import static racing.view.Input.makeCarNames;
import static racing.view.Input.makeGameRepeatCount;
import static racing.view.Output.*;

public class RacingController {
    public static void main(String[] args) {

        printStartMessage();
        String carNames = makeCarNames();
        String[] carNameArray = carNames.split(SEPARATOR);
        printResultMessage();
        RacingGame racingGame = new RacingGame(carNameArray);
        printInputCountMessage();
        int count = makeGameRepeatCount();
        racingGame.repeatMoveCars(count);

        printNowDistance(racingGame.getCars());
        printWinMessage(racingGame.findWinner());
    }
}
