package step2.race.service;

import step2.car.domain.Car;
import step2.car.domain.engine.Engine;
import step2.race.domain.Race;

import java.util.ArrayList;
import java.util.List;

public class RaceService {

    public void startRacing(Race race, int moveAmount) {
        for (int i = 0; i < moveAmount; i++) {
            race.moveAll();
        }
    }

    public List<Car> makeRacingCars(List<String> names, Engine engine) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name, engine);
            cars.add(car);
        }
        return cars;
    }

}
