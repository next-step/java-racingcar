package racing.service;

import java.util.ArrayList;
import java.util.List;
import racing.model.Car;
import racing.model.Cars;

public class RaceService {

    public Cars generateCar(int carCount) {
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            Car car = new Car();
            carList.add(car);
        }

        return new Cars(carList);
    }

    public void moveCar(Cars cars, int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            cars.moveAll();
        }
    }

}
