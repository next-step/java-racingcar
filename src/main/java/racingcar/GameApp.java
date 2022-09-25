package racingcar;

import racingcar.domain.RacingCarGame;
import racingcar.view.InputView;

public class GameApp {
    public static void main(String[] args) {
        int carNum = InputView.askNumberOfCar();
        int times = InputView.askTimes();
        RacingCarGame racingCarGame = new RacingCarGame(carNum, times);
        racingCarGame.start();
    }
}
