package racingcar;

import racingcar.view.ConsoleView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final ConsoleView view;
    private final RandomGenerator randomGenerator;

    public RacingGame(ConsoleView view, RandomGenerator randomGenerator) {
        this.view = view;
        this.randomGenerator = randomGenerator;
    }

    public void run() {
        List<String> names = view.namesOfCar();

        List<Car> cars = makeCarsOf(names);

        runWithCarsNTimes(view.numbOfTrial(), cars);
    }

    private List<Car> makeCarsOf(List<String> names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(Car.of(name));
        }

        return cars;
    }

    private void runWithCarsNTimes(int trials, List<Car> cars) {
        for (int i = 0; i < trials; i++) {
            moveAndPrint(cars);
        }
    }

    private void moveAndPrint(List<Car> cars) {

        for (Car car : cars) {
            int rand = randomGenerator.generate();
            car.moveDependingOn(rand);

            view.printCarLocation(car.location());
        }
    }
}
