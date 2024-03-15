package racing_winner.domain;

import racing.RandomFactory;
import racing_winner.view.CarRacingPrinter;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {
    private final List<Car> cars;
    private final int racingCount;
    private final RandomFactory randomFactory;
    private final CarRacingPrinter printer;

    public CarRacing(List<String> carNames, int racingCount,RandomFactory randomFactory, CarRacingPrinter carRacingPrinter) {
        this.racingCount = racingCount;
        this.cars = createCars(carNames);
        this.randomFactory = randomFactory;
        this.printer = carRacingPrinter;
    }

    private static List<Car> createCars(List<String> carNames) {
        return carNames.stream().map(Car::new).collect(Collectors.toUnmodifiableList());
    }

    public void game() {
        for (int i = 0; i < racingCount; i++) {
            step();
            printer.printRaceStatus(cars);
        }
        printer.printWinners(Winners.getWinners(cars));
    }

    private void step() {
        cars.forEach(car -> car.tryMove(randomFactory.getNextInt()));
    }

}
