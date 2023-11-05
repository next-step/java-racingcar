package racingCar;

import java.util.Arrays;

public class Car {

    private final StringBuilder distance = new StringBuilder();

    public void forward() {
        this.distance.append("-");
    }

    public String distance(){
        return this.distance.toString();
    }
}
