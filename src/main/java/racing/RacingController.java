package racing;

import racing.domain.Car;
import racing.domain.RacingGame;

import java.util.List;

import static racing.domain.RacingGame.SEPARATOR;
import static racing.view.Input.makeCarNames;
import static racing.view.Input.makeGameRepeatCount;
import static racing.view.Output.*;

public class RacingController {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();

        printStartMessage();
        String carNames = makeCarNames();
        String[] carNameArray = carNames.split(SEPARATOR);
        printResultMessage();
        racingGame.makeCars(carNameArray);
        printInputCountMessage();
        int count = makeGameRepeatCount();
        racingGame.repeatMoveCars(count);
        printNowDistance(racingGame.getCars());
        printWinMessage(racingGame.findWinner());
    }
}
