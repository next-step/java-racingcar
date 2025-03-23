package racingcar;

import racingcar.domain.Attempt;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.generator.RandomGenerator;
import racingcar.strategy.RandomStrategy;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    public static void gameStart() throws CloneNotSupportedException {
        int carNumber = InputView.inputValidatedNumberOfCar();
        int attempts = InputView.inputValidatedNumberOfAttempts();

        Race race = Race.create(carNumber, new Attempt(attempts));
        race.start(createRandomStrategy());
        ResultView.viewRoundResults(race.getRoundResults());

    }

    public static void gameStartWithName() throws CloneNotSupportedException {
        String[] carNames = InputView.inputdNameOfCar();
        int attempts = InputView.inputNumberOfAttempts();

        Race race = Race.create(carNames, new Attempt(attempts));
        race.start(createRandomStrategy());
        ResultView.viewRoundResultsWithName(race.getRoundResults());
        ResultView.viewRacingCarWinner(race.getWinners());

    }

    public static List<Car> getCars(int car) {
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < car; i++) {
            cars.add(new Car());
        }
        return cars;
    }


    private static RandomStrategy createRandomStrategy() {
        return new RandomStrategy(new RandomGenerator());
    }

}
