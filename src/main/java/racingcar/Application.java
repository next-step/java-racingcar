package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        int time = InputView.askTime();
        String[] carNames = InputView.askCarNames();

        List<Car> cars = CarFactory.create(carNames);
        RacingGame game = new RacingGame(time, cars);
        RacingResult results = game.run();

        ResultView.print(results);
    }
}
