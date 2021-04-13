package study.racingcar;

import java.util.Random;

public class Car {
    private int position = 0;

    public void move() {
        int randomNumber = new Random().nextInt(10);

        if (randomNumber >= 4) {
            forward();
        }
    }

    public void forward() {
        position++;
    }

    public void printDistance() {
        for (int i = 0; i < position; ++i) {
            System.out.print("-");
        }
        System.out.println();
    }
}
