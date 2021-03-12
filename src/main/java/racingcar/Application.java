package racingcar;

import racingcar.model.Cars;
import racingcar.module.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {

    public static void main(String[] arg) {
        Cars cars = new Cars(InputView.playCarNum());
        RacingGame game = new RacingGame();
        int tryNumber = InputView.tryGameNum();
    }
}
