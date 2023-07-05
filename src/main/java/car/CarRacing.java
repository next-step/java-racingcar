package car;

import car.domain.Car;
import car.domain.CarNames;
import car.domain.Cars;
import car.domain.TryCount;
import car.input.InputView;
import car.output.OutputView;
import car.util.RandomCarMovable;
import java.io.IOException;
import java.util.List;

public final class CarRacing {
    private Cars cars;

    public CarRacing() {
    }

    public void runRaceOnce() {
        cars.race(new RandomCarMovable());
    }

    public List<Car> selectWinner() {
        return cars.selectWinners();
    }

    public void run() throws IOException {
        String name = InputView.enterCarName();
        TryCount tryCount = new TryCount(InputView.enterCount());

        cars = new Cars(new CarNames(name));

        OutputView.printResult();
        for (int i = 0; i < tryCount.getTryCount(); i++) {
            runRaceOnce();
            OutputView.printEachRaceResult(cars);
        }

        OutputView.printEachRaceResult(cars);
        OutputView.printWinner(selectWinner());
    }
}
