package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntSupplier;

public class RacingGame {

    private final List<Car> cars;
    private final int tryCount;
    private final CarMover carMover = new CarMover();

    public RacingGame(List<String> names, int tryCount) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            this.cars.add(new Car(name));
        }
        this.tryCount = tryCount;
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }

    public void moveAll(IntSupplier numbers) {
        for (Car car : cars) {
            carMover.move(car, numbers.getAsInt());
        }
    }

    public List<TurnResult> race(IntSupplier numbers) {
        List<TurnResult> history = new ArrayList<>();
        for (int turn = 0; turn < tryCount; turn++) {
            moveAll(numbers);
            history.add(currentTurnResult());
        }
        return history;
    }

    public List<String> winners() {
        int maxPosition = Collections.max(cars, Comparator.comparingInt(Car::getPosition)).getPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            addIfWinner(winners, car, maxPosition);
        }
        return winners;
    }

    private void addIfWinner(List<String> winners, Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            winners.add(car.getName());
        }
    }

    private TurnResult currentTurnResult() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getPosition());
        }
        return new TurnResult(positions);
    }
}
