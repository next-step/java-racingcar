package racingcar;

import racingcar.domain.RacingCarGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class GameApp {
    public static void main(String[] args) {

        int carNum = InputView.askNumberOfCar();
        int times = InputView.askTimes();

        RacingCarGame racingCarGame = new RacingCarGame(carNum, times);
        ResultView.printGameHistory(racingCarGame.start());
    }
}
