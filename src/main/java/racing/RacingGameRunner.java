package racing;

import java.util.ArrayList;
import java.util.List;
import racing.domain.Car;
import racing.domain.GameResult;
import racing.domain.RacingGame;
import racing.ui.InputView;
import racing.ui.OutputView;
import racing.util.RandomNumberGenerator;

public class RacingGameRunner {

    public static void main(String[] args) {
        int carCount = InputView.readCarCount();
        int roundCount = InputView.readRoundCount();
        List<Car> cars = initialCars(carCount);

        RacingGame racingGame = RacingGame.setUp(roundCount, cars);
        List<GameResult> gameResults = racingGame.start();

        OutputView.printGameResults(gameResults);
    }

    private static List<Car> initialCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(Car.create(new RandomNumberGenerator()));
        }
        return cars;
    }
}
