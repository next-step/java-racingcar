package racingcar;

import racingcar.application.CarsGenerator;
import racingcar.application.RacingSimulator;
import racingcar.application.number.NumberGenerator;
import racingcar.application.number.RandomNumberGenerator;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class MainSimulator {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        CarsGenerator carsGenerator = new CarsGenerator();

        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        RacingSimulator racingSimulator = new RacingSimulator(randomNumberGenerator);

        String carName = inputView.insertNameOfCars();
        int racingCount = inputView.insertCount();

        List<Car> cars = carsGenerator.generateCars(carName);

        resultView.printHeader();
        racingSimulator.race(cars, racingCount);

        List<String> winnersNames = racingSimulator.getWinnersNames(cars);
        resultView.printWinners(winnersNames);

    }
}
