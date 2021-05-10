package racing;

import racing.domain.Car;
import racing.domain.RacingGame;

import java.util.List;

import static racing.domain.RacingGame.SEPARATOR;
import static racing.view.Input.makeCarNames;
import static racing.view.Input.makeGameRepeatCount;
import static racing.view.Output.*;
import static racing.view.Output.printWinMessage;

public class RacingController {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();

        printStartMessage();
        String carNames = makeCarNames();
        printInputCountMessage();
        int count = makeGameRepeatCount();
        printResultMessage();
        String[] carNameArray = carNames.split(SEPARATOR);
        List<Car> carList = racingGame.makeCars(carNameArray);
        carList = racingGame.repeatMoveCars(count, carList);
        printNowDistance(carList);
        printWinMessage(racingGame.findWinner(carList));
    }
}
