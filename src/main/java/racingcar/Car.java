package racingcar;

import java.util.Random;

public class Car {

    private int countOfMove = 0;
    private Random random = new Random();

    public Car() {

    }

    public void move() {
        int numberOfRandom = random.nextInt(10);
        if (numberOfRandom >= 4) {
            countOfMove++;
        }
    }

    protected void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < countOfMove; i++) {
            sb.append("-");
        }
        System.out.println(sb);
    }
}
