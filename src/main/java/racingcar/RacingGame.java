package racingcar;

import racingcar.view.ConsoleView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final ConsoleView view;
    private final RandomGenerator randomGenerator;
    private final List<Car> winners;
    private final List<Car> cars;

    public RacingGame(ConsoleView view, RandomGenerator randomGenerator) {
        this.view = view;
        this.randomGenerator = randomGenerator;
        this.winners = new ArrayList<>();
        this.cars = new ArrayList<>();
    }

    public void run() {
        List<String> names = view.namesOfCar();

        addCarsOf(names);

        runWithCarsNTimes(view.numbOfTrial());

        saveWinner();

        view.printWinners(winners);
    }

    private void addCarsOf(List<String> names) {
        for (String name : names) {
            cars.add(Car.of(name));
        }
    }

    private void runWithCarsNTimes(int trials) {
        for (int i = 0; i < trials; i++) {
            moveAndPrint();
        }
    }

    private void saveWinner() {
        this.cars.sort((car1, car2) -> car2.location() - car1.location());

        int maxLocation = this.cars.get(0).location();
        for(Car car : this.cars) {
            if(car.location() == maxLocation) {
                winners.add(car);
            }
        }
    }

    private void moveAndPrint() {
        for (Car car : this.cars) {
            int rand = randomGenerator.generate();
            car.moveDependingOn(rand);
        }

        view.printCarsLocation(this.cars);
    }
}
