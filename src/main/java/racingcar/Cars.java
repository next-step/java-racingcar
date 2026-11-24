package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntSupplier;

public class Cars {

    private final List<Car> cars;
    private final CarMover carMover = new CarMover();

    public Cars(List<String> names) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            this.cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }

    public void moveAll(IntSupplier numbers) {
        for (Car car : cars) {
            carMover.move(car, numbers.getAsInt());
        }
    }

    public TurnResult toTurnResult() {
        List<CarStatus> statuses = new ArrayList<>();
        for (Car car : cars) {
            statuses.add(new CarStatus(car.getName(), car.getPosition()));
        }
        return new TurnResult(statuses);
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
}
