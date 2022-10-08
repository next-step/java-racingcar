package racinggame;

import racinggame.controller.RacingGame;
import racinggame.component.RandomNumberGenerator;
import racinggame.domain.Car;
import racinggame.model.RacingGameResult;
import racinggame.view.InputView;
import racinggame.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameApplication {

    public static void main(String[] args) {
        List<Car> cars = InputView.inputCarNames().stream()
                .map(Car::new)
                .collect(Collectors.toList());
        int tryCount = InputView.inputTryCount();
        RacingGame game = new RacingGame(new RandomNumberGenerator());
        RacingGameResult result = game.run(cars, tryCount);
        OutputView.printResult(result);
    }

}
