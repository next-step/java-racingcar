package car.step3;

import java.util.Objects;

public class Car {
    private int location = 0;
    private String DASH = "-";

    public void go() {
        this.location++;
    }

    public int location() {
        return location;
    }

}
