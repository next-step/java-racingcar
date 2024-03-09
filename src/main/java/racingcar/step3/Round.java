package racingcar.step3;

import racingcar.step3.move.MoveStrategy;
import racingcar.step3.print.PrintStrategy;

import java.util.ArrayList;
import java.util.List;

public class Round {

    private final List<Car> cars;
    private final MoveStrategy moveStrategy;
    private final PrintStrategy printStrategy;

    public Round(MoveStrategy moveStrategy, int carsNumber, PrintStrategy printStrategy) {
        this.moveStrategy = moveStrategy;
        this.cars = createCarsList(carsNumber);
        this.printStrategy = printStrategy;
    }

    public void startRound() {
        cars.forEach(Car::move);
    }

    public void printRoundResult() {
        printStrategy.printRoundResult(cars);
    }

    private List<Car> createCarsList(int carNumbers) {
        List<Car> cars = new ArrayList<Car>();

        for (int i = 0; i < carNumbers; i++) {
            cars.add(new Car(moveStrategy));
        }

        return cars;
    }
}
