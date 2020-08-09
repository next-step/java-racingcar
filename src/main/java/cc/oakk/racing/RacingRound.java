package cc.oakk.racing;

import cc.oakk.racing.printer.Printable;
import cc.oakk.racing.printer.Printer;
import cc.oakk.racing.util.Validator;

import java.util.List;

public class RacingRound implements Printable<Car> {
    private final List<Car> cars;
    private final int totalRoundCount;

    private int currentRoundCount = 0;

    public RacingRound(List<Car> cars, int totalRoundCount) {
        Validator.checkList(cars);
        Validator.checkGreaterThanZero(totalRoundCount);

        this.cars = cars;
        this.totalRoundCount = totalRoundCount;
    }

    public boolean hasNextRound() {
        return totalRoundCount > currentRoundCount;
    }

    public RacingRound nextRound() {
        if (!hasNextRound()) {
            throw new IndexOutOfBoundsException("Round has over!");
        }
        cars.forEach(Car::tryMoveForward);
        currentRoundCount++;
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
