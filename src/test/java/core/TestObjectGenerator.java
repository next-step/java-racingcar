package core;

import utils.NumberGenerator;

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

    public static NumberGenerator generateMoveNumberGenerator() {
        return () -> Car.BASE_MOVE_VALUE;
    }

    public static RaceModel generateRaceModel(Cars cars, int moveCount) {
        RaceModel raceModel = new RaceModel();
        raceModel.setCars(cars);
        raceModel.setMoveCount(moveCount);
        return raceModel;
    }
}
