package step3.service;

import step3.domain.Car;
import step3.domain.Cars;
import step3.utils.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public List<Car> setCars(int howManyCars) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < howManyCars; i++) {
            carList.add(new Car(i));
        }
        return carList;
    }

    public void play(Cars cars, int round) {
        for (int i = 0; i < round; i++) {
            raceByRound(cars);
        }
    }

    public void raceByRound(Cars cars) {
        for (int i = 0; i < cars.getCars().size(); i++) {
            Car car = cars.getCars().get(i);
            car.move(new RandomUtil());
        }
    }

}
