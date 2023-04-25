package racingcar;

import racingcar.car.Car;
import racingcar.car.Winners;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final int numbOfTrial;
    private final List<String> carNames;
    private final WinnerDecisionStrategy winnerDecisionStrategy;
    private final List<Car> cars;
    private Winners winners;

    public RacingGame(int numbOfTrial,
                      List<String> carNames,
                      WinnerDecisionStrategy winnerDecisionStrategy) {
        this.numbOfTrial = numbOfTrial;
        this.carNames = carNames;
        this.winnerDecisionStrategy = winnerDecisionStrategy;
        this.winners = new Winners(new ArrayList<>());
        this.cars = new ArrayList<>();
    }

    public List<Car> allCars() {
        return this.cars;
    }

    public Winners winners() {
        return this.winners;
    }

    public void run() {
        addCarsOf();

        runWithCarsNTimes();

        pickWinners();
    }

    private void addCarsOf() {
        for (String name : this.carNames) {
            cars.add(new Car(name));
        }
    }

    private void runWithCarsNTimes() {
        for (int i = 0; i < this.numbOfTrial; i++) {
            moveCar();
        }
    }

    private void pickWinners() {
        this.winners =
                winnerDecisionStrategy.decideWinners(this.cars);
    }

    private void moveCar() {
        for (Car car : this.cars) {
            car.move();
        }
    }
}
