package car;

import car.domain.Car;
import car.domain.CarNames;
import car.domain.Cars;
import car.domain.TryCount;
import car.input.InputView;
import car.output.OutputView;
import car.util.NumberGenerator;
import car.util.RandomNumberGenerator;
import java.util.List;

public final class RacingController {

    private Cars cars;
    private TryCount leftRound;

    public RacingController() {
    }

    public void runRaceOnce(NumberGenerator numberGenerator) {
        cars.race(numberGenerator);
        leftRound.decreaseCount();
    }

    public List<Car> selectWinner() {
        return cars.selectWinners();
    }

    private boolean isLeftRound() {
        return this.leftRound.isPositive();
    }

    public void run() {
        String name = InputView.enterCarName();
        leftRound = new TryCount(InputView.enterCount());

        cars = new Cars(new CarNames(name));
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        OutputView.printResult();

        while (isLeftRound()) {
            runRaceOnce(numberGenerator);
            OutputView.printEachRaceResult(cars);
        }

        OutputView.printEachRaceResult(cars);
        OutputView.printWinner(selectWinner());
    }
}
