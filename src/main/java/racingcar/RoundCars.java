package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.strategy.MovingStrategy;

public class RoundCars {

    private final List<Car> cars = new ArrayList<>();

    public RoundCars(int carNums) {
        Positive positive = new Positive(carNums);
        for (int i = 0; i < positive.getNumber(); i++) {
            cars.add(new Car());
        }
    }

    public RoundCars(List<Car> cars) {
        this.cars.addAll(cars);
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
            recordCars.add(new Car(car.getPosition()));
        }
        return new RoundCars(recordCars);
    }

    public List<Car> retrieveCars() {
        return cars;
    }
}
