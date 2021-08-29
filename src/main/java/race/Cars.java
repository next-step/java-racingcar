package race;

import java.util.*;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(String[] carNames, List<Car> cars) {
        Car car;
        for (String carName : carNames) {
            car = Car.createCar(carName, new ArrayList<Boolean>());
            cars.add(car);
        }
        return new Cars(cars);
    }

    protected final List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    protected Cars moveCars(MoveCondition moveCondition) {
        for (int i = 0; i < this.getCars().size(); i++) {
            this.getCars().get(i).addDistance(moveCondition);
        }
        return this;
    }

}
