package racingcar;

import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.domain.RacingCarGame;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        int carCount = InputView.promptCarCount();
        int rounds = InputView.promptRounds();

        List<Car> cars = CarFactory.generateCarsOfSize(carCount);
        MoveStrategy strategy = new RandomMoveStrategy();

        RacingCarGame game = new RacingCarGame(cars, rounds, strategy);

        OutputView.printRaceStart();
        for (int i = 0; i < rounds; i++) {
            game.proceedRound();
            OutputView.printCars(cars);
        }
    }
}
