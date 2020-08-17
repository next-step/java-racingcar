package step4.controller;

import step4.model.Cars;

public class UserInput {

    private Cars cars;
    private int tries;

    public UserInput(Cars cars, int tries) {
        this.cars = cars;
        this.tries = tries;
    }

    public Cars getCars() {
        return cars;
    }

    public int getTries() {
        return tries;
    }
}
