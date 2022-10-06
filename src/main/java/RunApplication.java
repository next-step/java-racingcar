import domain.Car;
import view.InputView;
import view.ResultView;

import java.util.List;

public class RunApplication {
    public static void main(String[] args) {
        play();
    }

    private static void play() {
        InputView inputView = new InputView();
        RacingGame racingGame = new RacingGame();
        ResultView resultView = new ResultView();

        inputView.printCarCntInputText();
        int carCnt = inputView.getUserInputToInteger();

        inputView.printTryCntInputText();
        int tryCnt = inputView.getUserInputToInteger();

        List<Car> cars = racingGame.makeCars(carCnt);

        resultView.printResultTitle();
        for (int i = 0; i < tryCnt; i++) {
            racingGame.game(cars);
            resultView.printRacingResult(cars);
        }
    }
}


