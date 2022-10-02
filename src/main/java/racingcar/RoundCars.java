package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.strategy.MovingStrategy;

public class RoundCars {

    private final List<Car> cars;

    public RoundCars() {
        cars = new ArrayList<>();
    }

    public RoundCars(List<String> names) {
        cars = names
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCars(RacingRecord racingRecord, MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
        racingRecord.addCarsPosition(this);
    }

    public List<String> retrieveWinners() {
        int maxPosition = retrieveMaxPosition();
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public RoundCars getRoundCars() {
        List<Car> recordCars = new ArrayList<>();
        List<Car> cars = this.retrieveCars();

        for (Car car : cars) {
            recordCars.add(new Car(car.getPosition(), car.getName()));
        }
        return createRoundCars(recordCars);
    }

    public List<Car> retrieveCars() {
        return cars;
    }

    private RoundCars createRoundCars(List<Car> cars) {
        RoundCars roundCars = new RoundCars();
        roundCars.addCars(cars);
        return roundCars;
    }

    private void addCars(List<Car> cars) {
        this.cars.addAll(cars);
    }

    private int retrieveMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

}
