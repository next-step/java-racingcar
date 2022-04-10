package car;

import java.util.Random;

public class Car {
    private int distance;

    public Car() {
        this.distance = 0;
    }

    public int move(int number) {
        if (number < 4) {
            return this.distance;
        }

        this.distance ++;
        return this.distance;
    }

    public int randomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public void printDistance() {
        for (int i = 0; i < this.distance; i++) {
            System.out.print("-");
        }
    }

    public boolean isMove() {
        return this.distance > 0;
    }
}
