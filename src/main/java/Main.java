import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomMovableStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int carCount = InputView.receiveCarCount();
        int roundCount = InputView.receiveRoundCount();

        List<Car> inputCars = IntStream.range(0, carCount).
                mapToObj(index -> new Car())
                .collect(Collectors.toList());
        Cars cars = new Cars(inputCars);

        RacingGame racingGame = new RacingGame(roundCount, new RandomMovableStrategy());
        while (!racingGame.isEnd()) {
            racingGame.race(cars);
            ResultView.print(cars);
        }
    }
}
