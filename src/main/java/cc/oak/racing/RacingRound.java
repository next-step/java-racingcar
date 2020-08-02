package cc.oak.racing;

import cc.oak.racing.printer.Printable;
import cc.oak.racing.printer.Printer;

import java.util.List;

public class RacingRound implements Printable<Car> {
    private final List<Car> cars;
    private final int totalRoundCount;

    private int currentRoundCount = 0;

    public RacingRound(List<Car> cars, int totalRoundCount) {
        if (cars == null) {
            throw new IllegalArgumentException("cars are null!");
        }

        if (totalRoundCount < 0) {
            throw new IllegalArgumentException("totalRoundCount should be greater than zero.");
        }

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

    @Override
    public void print(Printer<Car> printer) {
        cars.forEach(car -> car.print(printer));
    }
}
