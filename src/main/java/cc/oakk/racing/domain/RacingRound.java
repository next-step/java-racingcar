package cc.oakk.racing.domain;

import cc.oakk.racing.view.printer.Printable;
import cc.oakk.racing.view.printer.Printer;
import cc.oakk.racing.util.Validator;

import java.util.List;

public class RacingRound implements Printable<Car> {
    private final List<Car> cars;
    private final RoundCount roundCount;

    public RacingRound(List<Car> cars, int roundCount) {
        Validator.checkList(cars);

        this.cars = cars;
        this.roundCount = new RoundCount(roundCount);
    }

    public boolean hasNextRound() {
        return roundCount.hasNextRound();
    }

    public RacingRound nextRound() {
        roundCount.increase();
        cars.forEach(Car::tryMoveForward);
        return this;
    }

    public Ranking getRanking() {
        return new Ranking(cars);
    }

    @Override
    public void print(Printer<Car> printer) {
        cars.forEach(car -> car.print(printer));
    }
}
