package step3.main;

import step3.domain.Car;
import step3.domain.UserInput;
import step3.service.GameStrategy;
import step3.service.RacingCarGame;
import step3.view.InputView;
import step3.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        final UserInput input = InputView.input();
        final GameStrategy game = new RacingCarGame(input.getCount());

        OutputView.printResultConsole();

        for (int i = 0; i < input.getRetry(); i++) {
            final List<Car> cars = game.playGame();
            OutputView.printAllCar(cars);
        }
    }
}
