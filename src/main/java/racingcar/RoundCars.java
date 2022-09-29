package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.strategy.MovingStrategy;

public class RoundCars {

    private final List<Car> cars = new ArrayList<>();

    private RoundCars() {
    }

    public RoundCars(List<String> names) {
        names
                .stream()
                .map(Car::new)
                .forEach(cars::add);
    }

    public static RoundCars createRoundCars(List<Car> cars) {
        RoundCars roundCars = new RoundCars();
        roundCars.addCars(cars);
        return roundCars;
    }

    public void moveCars(RacingRecord racingRecord, MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
        racingRecord.addCarsPosition(this);
    }

    public RoundCars deepCopy() {
        List<Car> recordCars = new ArrayList<>();
        List<Car> cars = this.retrieveCars();

        for (Car car : cars) {
            recordCars.add(new Car(car.getPosition(), car.getName()));
        }
        return RoundCars.createRoundCars(recordCars);
    }

    public List<Car> retrieveCars() {
        return cars;
    }

    private void addCars(List<Car> cars) {
        this.cars.addAll(cars);
    }

}
