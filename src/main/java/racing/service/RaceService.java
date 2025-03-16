package racing.service;

import java.util.ArrayList;
import java.util.List;
import racing.model.Car;
import racing.model.Cars;

public class RaceService {

    public Cars generateCar(int carCount, NumberGenerator numberGenerator) {
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            Car car = new Car();
            carList.add(car);
        }

        return new Cars(carList, numberGenerator);
    }

    public void moveCar(Cars cars) {
        cars.moveAll();
    }

}
