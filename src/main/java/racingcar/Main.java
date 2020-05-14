package racingcar;

import racingcar.domain.Car;
import racingcar.domain.GameResult;
import racingcar.domain.RacingCarGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        InputView input = InputView.create();

        int carCount = input.getCarCount();
        int moveCount = input.getMoveCount();

        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }

        RacingCarGame racingCarGame = new RacingCarGame(cars);

        OutputView.printMessage();

        for (int i = 0; i < moveCount; i++) {
            GameResult result = racingCarGame.execute();
            OutputView.printOut(result);
        }
    }
}
