package racing;

import java.util.ArrayList;
import java.util.List;
import racing.domain.Car;
import racing.domain.RacingGame;
import racing.domain.RoundResult;
import racing.ui.InputView;
import racing.ui.OutputView;
import racing.util.RandomNumberGenerator;

public class RacingGameRunner {

    public static void main(String[] args) {
        List<String> carNames = InputView.readCarNames();
        int roundCount = InputView.readRoundCount();
        List<Car> cars = initialCars(carNames);

        RacingGame racingGame = RacingGame.setUp(roundCount, cars);
        List<RoundResult> gameResults = racingGame.start();

        OutputView.printGameResults(gameResults);
    }

    private static List<Car> initialCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(Car.create(name, new RandomNumberGenerator()));
        }
        return cars;
    }
}
