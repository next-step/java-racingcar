package core;

import utils.PowerSupply;

import java.util.ArrayList;
import java.util.List;

public class TestObjectGenerator {
    public static Car generateCar(String inputCarName, int position) {
        CarName carName = CarName.create(inputCarName);
        Car car = Car.create(carName);
        for (int i = 0; i < position; i++) {
            car = car.move(Car.BASE_MOVE_VALUE);
        }
        return car;
    }

    public static Cars generateCars(Car car, int count) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            carList.add(car);
        }

        return Cars.fromCars(carList);
    }

    public static PowerSupply generateMovablePowerSupply() {
        return () -> Car.BASE_MOVE_VALUE;
    }

    public static RaceModel generateRaceModel(String inputCarName, int carCount, int moveCount) {
        List<CarName> carNames = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carNames.add(CarName.create(inputCarName));
        }
        return RaceModel.initialize(carNames, moveCount);
    }

    public static List<CarName> generateCarNames() {
        List<CarName> carNames = new ArrayList<>();
        carNames.add(CarName.create("a"));
        carNames.add(CarName.create("b"));
        carNames.add(CarName.create("c"));
        return carNames;
    }
}
