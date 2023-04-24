package racingcar;

import racingcar.util.RandomGenerator;
import racingcar.view.ConsoleView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final ConsoleView view;
    private final WinnerDecisionStrategy winnerDecisionStrategy;
    private final List<Car> cars;
    private List<Car> winners;

    public RacingGame(ConsoleView view,
                      WinnerDecisionStrategy winnerDecisionStrategy) {

        this.view = view;
        this.winnerDecisionStrategy = winnerDecisionStrategy;
        this.winners = new ArrayList<>();
        this.cars = new ArrayList<>();
    }

    public void run() {
        List<String> names = view.namesOfCar();

        addCarsOf(names);

        runWithCarsNTimes(view.numbOfTrial());

        pickWinners();

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

    private void pickWinners() {
        this.winners = winnerDecisionStrategy.decideWinners(this.cars);
    }

    private void moveAndPrint() {
        for (Car car : this.cars) {
            car.moveDependingOn(RandomGenerator.generate(0, 9));
        }

        view.printCarsLocation(this.cars);
    }
}
