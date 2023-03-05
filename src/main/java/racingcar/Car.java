package racingcar;

import java.util.Random;

public class Car {
    final private String name;
    private int position;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        }
        this.name = name;
    }

    public void printPosition() {
        System.out.println(this.name + ": " + "-".repeat(position));
    }

    public void move() {
        Random random = new Random();

        if (random.nextInt(10) >= 4) {
            position += 1;
        }

        printPosition();
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
