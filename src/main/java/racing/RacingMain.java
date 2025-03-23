package racing;

import racing.domain.Car;
import racing.domain.Judgement;
import racing.domain.RacingGame;
import racing.views.InputView;
import racing.views.ResultView;

import java.util.List;

public class RacingMain {

    public static void main(String[] args) {

        String[] carNames = InputView.inputCarNames();

        RacingGame racingGame = new RacingGame(carNames);

        int tryTimes = InputView.inputTryTimes();

        ResultView.showResult();

        for (int j = 0; j < tryTimes; j++) {
            racingGame.moveCars();
        }

        ResultView.printWinner(new Judgement(racingGame.getCars()).getWinnerCars());
    }
}
