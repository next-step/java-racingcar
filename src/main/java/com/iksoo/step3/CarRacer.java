package com.iksoo.step3;

import java.util.List;
import java.util.Random;

public class CarRacer {
    private final int GOSTOP_CRITERION = 4;

    private OutputRacingData outputRacingInfo = new OutputRacingData();
    private Random random = new Random();
    private final List<Car> cars;

    public CarRacer(List<Car> cars) {
        this.cars = cars;
        startRacing(this.cars);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void startRacing(List<Car> cars) {
        for (int i = 0; i < cars.get(0).getTotalInning(); i++) {
            doOneInning(cars);
            outputRacingInfo.printBlankLine();
        }
    }

    public void doOneInning(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).addNextInning(getRandom(), GOSTOP_CRITERION);
        }
    }

    public int getRandom() {
        return random.nextInt(10);
    }
}
