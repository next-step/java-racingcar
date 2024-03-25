package study.racingcar;

import java.util.Random;

public class Car {

    private int position;

    public boolean canMove() {
        Random random = new Random();

        return random.nextInt(10) >= 4;
    }

    public void move() {
        canMove();
        if (canMove()) {
            position++;
        }
        convertToDash(this.position);
    }

    private void convertToDash(int position) {
        System.out.print("-".repeat(position));
    }
}
