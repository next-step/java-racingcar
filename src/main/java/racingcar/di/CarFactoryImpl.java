package racingcar.di;

import racingcar.domain.Car;
import racingcar.domain.Engine;
import racingcar.domain.NormalEngine;
import racingcar.domain.RacingCar;
import java.util.ArrayList;
import java.util.List;

public class CarFactoryImpl implements CarFactory{

    @Override
    public List<Car> makeCars(String[] names) {
        List<Car> cars = new ArrayList<>();
        Engine normalEngine = new NormalEngine();
        for (String name : names) {
            Car car = new RacingCar(name, normalEngine);
            cars.add(car);
        }
        return cars;
    }
}