package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactoryImpl implements CarFactory{

    @Override
    public List<Car> makeCars(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            Car car = new RacingCar(name);
            cars.add(car);
        }
        return cars;
    }
}