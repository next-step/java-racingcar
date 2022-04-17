package racingcar.model;

import racingcar.pattern.ValueGenerateStrategy;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {
    private final List<Car> cars;

    public CarGroup(List<Car> cars) {
        this.cars = cars;
    }

    public static List<Car> createCars(PositiveNumber carPositiveNumber) {
        List<Car> cars = new ArrayList<>();
        for (int i = 1; i <= carPositiveNumber.getNumber(); i++) {
            cars.add(new Car(0));
        }
        return cars;
    }

    public void moveCarGroup(PositiveNumber trialNumber, ValueGenerateStrategy valueGenerateStrategy) {
        for (int i = 0; i < trialNumber.getNumber(); i++) {
            moveCarGroupPerTrial(valueGenerateStrategy);
        }
    }

    private void moveCarGroupPerTrial(ValueGenerateStrategy valueGenerateStrategy) {
        for (Car car : this.cars) {
            car.tryToMove(valueGenerateStrategy);
        }
    }
}
