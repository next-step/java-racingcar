package car.step3.service;

import car.step3.domain.Car;
import car.step3.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    MovingStrategy movingStrategy = new RandomMovingStrategy();

    public List<Car> iteratorCar(List<Car> cars) {
        for (Car car : cars) {
            goCar(car);
        }
        return cars;
    }

    public List<Car> makeCar(String carNames) {
        List<Car> carList = new ArrayList<Car>();
        String[] cars =  carNames.split(",");
        for (String car : cars) {
            carList.add(new Car(car));
        }
        return carList;
    }

    public void goCar(Car car) {
        car.go(movingStrategy);
    }

    public List<Car> findWinners(List<Car> origin) {
        Cars cars = new Cars(origin);
        return cars.findWinners();
    }
}
