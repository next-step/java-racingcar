package step3.model;

import step3.util.Constant;

public class Car {

    private int location;

    public Car() {
        this.location = Constant.CAR_INITIAL_LOCATION;
    }

    public int getLocation() {
        return location;
    }

    public void move(int randomNum) {
        if (randomNum >= Constant.MOBILITY_JUDGMENT_NUMBER) {
            this.location++;
        }
    }
}
