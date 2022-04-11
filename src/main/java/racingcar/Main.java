package racingcar;

import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.domain.RacingCarGame;
import racingcar.domain.RandomGenerator;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        int carCount = InputView.promptCarCount();
        int rounds = InputView.promptRounds();
        List<Car> cars = CarFactory.generateCarsOfSize(carCount);

        RacingCarGame game = new RacingCarGame(cars, rounds);

        OutputView.printRaceStart();
        for (int i = 0; i < rounds; i++) {
            List<Integer> randomNumbers = RandomGenerator.generateRandomsOfSize(cars.size());
            game.proceedRound(randomNumbers);
            OutputView.printCars(cars);
        }
    }

}
