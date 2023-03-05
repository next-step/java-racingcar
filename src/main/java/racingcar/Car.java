package racingcar;

import java.util.Random;

public class Car {
    private String name;
    private int location;

    public Car(String name, int location) {

        // 자동차 이름은 5자를 초과할 수 없다.
        if(name.length() > 5) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.location = location;
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }

    public void goOrStay() {
        Random random = new Random();
        int num = random.nextInt(10);

        if (num >= 4) {
            this.location++;
        }
    }

}
