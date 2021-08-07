package edu.nextstep.racingcarwinner.domain;

import edu.nextstep.racingcarwinner.strategy.RacingStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<Car> carList;

    private RacingCars(List<Car> carList) {
        this.carList = carList;
    }

    public static RacingCars makeRacingCars(List<Car> carList) {
        return new RacingCars(carList);
    }

    public static List<Car> makeCarList(String[] carNameArr) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNameArr) {
            carList.add(new Car(name));
        }
        return carList;
    }


    public void move(RacingStrategy racingStrategy) {
        for (Car car : carList) {
            car.move(racingStrategy);
        }
    }

    public List<Car> getWinner() {
        List<Car> winners = new ArrayList<>();
        int maxDistance = 0;

        for (Car car : carList) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }

        for (Car car : carList) {
            if (car.getDistance() == maxDistance) {
                winners.add(car);
            }
        }

        return winners;
    }

    public List<Car> getCarList() {
        return this.carList;
    }
}
