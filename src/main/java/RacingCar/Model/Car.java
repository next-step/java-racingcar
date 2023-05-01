package RacingCar.Model;

import java.util.ArrayList;

public class Car {

    private static final int FORWARD_NUM = 4;
    private static final int LIMIT_NUM = 5;
    private int location;
    private String name;

    public Car(int location, String name) {
        if (name.length() > LIMIT_NUM)
            throw new IllegalArgumentException(name + "의 자동차 이름은 " + LIMIT_NUM + "자 이하여야 합니다.");

        this.location = location;
        this.name = name;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= FORWARD_NUM)
            this.location++;
    }

}