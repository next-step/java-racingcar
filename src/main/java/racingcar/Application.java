package racingcar;

import racingcar.model.Cars;
import racingcar.model.Winner;
import racingcar.module.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {

    public static void main(String[] arg) {
        Cars cars = new Cars(InputView.playCarName());
        RacingGame game = new RacingGame();
        int tryNumber = InputView.tryGameNum();
        ResultView.printResultView(game.startGame(cars, tryNumber), new Winner(cars.getCars()));
    }
}
