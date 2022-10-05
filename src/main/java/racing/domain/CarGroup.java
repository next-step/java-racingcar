package racing.domain;

import racing.domain.car.Car;
import racing.domain.car.movingstrategy.RandomNumberMovingStrategy;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {

    private final List<Car> cars;

    public CarGroup(List<Car> cars) {
        this.cars = cars;
    }

    public CarGroup moveAll() {
        for (Car car : cars) {
            car.move(new RandomNumberMovingStrategy());
        }
        return this;
    }

    public List<Car> leadingGroup() {
        Car leadingCar = getLeadingCar();
        return getLeadingGroup(leadingCar);
    }

    public List<Car> getCars() {
        return cars;
    }

    private List<Car> getLeadingGroup(Car leadingCar) {
        List<Car> leadingGroup = new ArrayList<>();
        for (Car car : cars) {
            addIfLeading(leadingGroup, leadingCar, car);
        }
        return leadingGroup;
    }

    private Car getLeadingCar() {
        Car leadingCar = null;
        for (Car car : cars) {
            leadingCar = car.leading(leadingCar);
        }
        return leadingCar;
    }

    private void addIfLeading(List<Car> leadingGroup, Car leadingCar, Car comparedCar) {
        if (isSamePosition(leadingCar, comparedCar)) {
            leadingGroup.add(comparedCar);
        }
    }

    private boolean isSamePosition(Car leadingCar, Car car) {
        return car.isSamePosition(leadingCar);
    }
}
