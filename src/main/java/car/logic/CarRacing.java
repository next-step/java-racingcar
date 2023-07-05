package car.logic;

import car.domain.Car;
import car.domain.CarNames;
import car.domain.Cars;
import car.domain.RandomCarMovable;
import car.domain.TryCount;
import car.input.InputView;
import car.output.OutputView;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {

    private static Cars cars;

    public CarRacing(Cars cars) {
        this.cars = cars;
    }

    public static Cars runRaceOnce() {
        cars.race(new RandomCarMovable());
        return getRaceResult();
    }

    public static Cars getRaceResult() {
        return cars;
    }

    public static List<Car> selectWinner() {
        int maxPos = cars.getCars().stream().map(Car::getPosition)
            .max(Comparator.comparing(x -> x)).get();
        return cars.getCars().stream().filter(s -> (s.getPosition() == maxPos))
            .collect(Collectors.toList());
    }

    public static void run() throws IOException {
        InputView.printName();
        String name = InputView.enterCarName();
        
        InputView.printCount();
        TryCount tryCount = new TryCount(InputView.enterCount());

        cars = new Cars(new CarNames(name));
        OutputView.printResult();
        for (int i = 0; i < tryCount.getTryCount(); i++) {
            OutputView.printEachRaceResult(runRaceOnce());
        }

        OutputView.printEachRaceResult(getRaceResult());
        OutputView.printWinner(selectWinner());
    }
}
