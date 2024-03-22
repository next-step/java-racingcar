package study.racingcar;

import java.util.Random;

public class Car {

    boolean move;
    public Car() {

    }

    public boolean canMove() {
        Random random = new Random();

        return random.nextInt(10) >= 4;
    }

    public void move() {
        System.out.print("-");
    }
}
