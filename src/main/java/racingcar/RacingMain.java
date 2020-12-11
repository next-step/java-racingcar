package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingMain {
    private static Cars cars;

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int playCount = inputView.inputCountOfPlay();
        int carCount = inputView.inputCountOfCar();

        RacingGame game = new RacingGame(playCount, carCount);
        game.start();
    }
}
