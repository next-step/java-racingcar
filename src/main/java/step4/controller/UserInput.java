package step4.controller;

import step4.model.Car;

public class UserInput {

    private Car[] cars;
    private int tries;

    public UserInput(Car[] cars, int tries) {
        this.cars = cars;
        this.tries = tries;
    }

    public Car[] getCars() {
        return cars;
    }

    public int getTries() {
        return tries;
    }
}
