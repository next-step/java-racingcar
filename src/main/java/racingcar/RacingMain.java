package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] carNames = inputView.inputNameOfCar();
        int playCount = inputView.inputCountOfPlay();

        RacingGame game = new RacingGame(carNames, playCount);
        game.start();
    }
}
