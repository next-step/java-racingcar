package step2.race.service;

import step2.car.domain.car.Car;
import step2.car.domain.car.engine.Engine;
import step2.race.domain.Race;

import java.util.ArrayList;
import java.util.List;

public class RaceService {

    public void startRacing(Race race, int moveAmount) {
        for (int i = 0; i < moveAmount; i++) {
            race.moveAll();
        }
    }

    public List<Car> makeRacingCars(int carAmount, Engine engine) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carAmount; i++) {
            Car car = new Car(engine);
            cars.add(car);
        }
        return cars;
    }

}
