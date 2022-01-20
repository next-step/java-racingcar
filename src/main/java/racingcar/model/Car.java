package racingcar.model;

import racingcar.util.RandomGenerator;

public class Car {
    private String carName;
    private String position;
    public Car(String carName){
        this.carName= carName;
        this.position="";
    }

    public String getCarName() {
        return carName;
    }

    public String getPosition() {
        return position;
    }
}
