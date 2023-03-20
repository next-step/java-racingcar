package racingcar;

import java.util.Random;

public class Car {
    final String name;
    int location;

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }


    public int rand() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        return random.nextInt(10);
    }


    public void moveCar() {
        this.location++;
    }

    public String getName() {
        return this.name;
    }

}
