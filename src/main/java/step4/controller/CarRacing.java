package step4.controller;

import step4.model.Cars;

public class CarRacing {
    private int numOfTries;
    private Cars cars;

    public CarRacing(Cars cars, int numOfTries) {
        this.cars = cars;
        this.numOfTries = numOfTries;
    }

    public Cars gameStart() {
        for (int i = 0; i < numOfTries; i++) {
            cars.carsMove();
        }
        return cars;
    }
}


