package step3.service;

import step3.domain.Car;
import step3.domain.Cars;
import step3.utils.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final int howManyCars;
    private final int round;

    public RacingGame(int howManyCars, int round) {
        this.howManyCars = howManyCars;
        this.round = round;
    }

    public List<Car> setCars() {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < howManyCars; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    public void play(Cars cars) {
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
