package car.logic;

import car.domain.Car;
import car.domain.Cars;
import car.domain.Count;
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
        cars.raceOnce();
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
        Count count = new Count(InputView.enterCount());

        cars = new Cars(name);
        OutputView.printResult();
        for (int i = 0; i < count.getTryCount(); i++) {
            OutputView.printEachRaceResult(runRaceOnce());
        }

        OutputView.printEachRaceResult(getRaceResult());
        OutputView.printWinner(selectWinner());
    }
}
