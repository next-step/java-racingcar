package study.race.model;

import study.race.model.Cars;

public class CarListGenerator {

    public Cars generateCarList(String[] carNameList) {
        Cars cars = new Cars();
        for (int i = 0; i < carNameList.length; i++) {
            cars.addCar();
        }
        return cars;
    }
}
