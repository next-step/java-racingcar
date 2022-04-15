package model;

import exception.NegativeCarsNumberException;

public class PositiveCarsNumber {
    private int carsNumber;

    private PositiveCarsNumber() {

    }

    public PositiveCarsNumber(int carsNumber) {
        if (carsNumber <= 0) {
            throw new NegativeCarsNumberException();
        }

        this.carsNumber = carsNumber;
    }

    public int getCarsNumber() {
        return carsNumber;
    }
}
