package study.race.model;

import study.race.model.Cars;

public class CarListGenerator {

    public Cars generateCarList(int numberOfCar) {
        Cars cars = new Cars();
        for (int i = 0; i < numberOfCar; i++) {
            cars.addCar();
        }
        return cars;
    }
}
