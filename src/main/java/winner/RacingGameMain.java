package winner;

import winner.view.CarRaceInputView;
import winner.view.CarRaceResultView;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-01 22:46
 */
public class RacingGameMain {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(CarRaceInputView.inputCarName(), CarRaceInputView.inputTryNo());
        while (!racingGame.isEnd()) {
            racingGame.start();
            CarRaceResultView.printCars(racingGame.getRacingCars());
        }

        CarRaceResultView.printWinner(racingGame.getWinner());
    }
}
