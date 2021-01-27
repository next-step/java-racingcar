package racingcarRefactor.domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position;
    private int GO = 4;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        Random random = new Random();
        int token = random.nextInt(10);
        if (token >= GO) {
            position++;
        }
    }
}
