package car;

import java.util.Random;

public class Car {
    private int distance;
    private CarRacing carRacing;

    public Car(CarRacing carRacing) {
        this.distance = 0;
        this.carRacing = carRacing;
    }

    public int move(int number) {
        if (number < carRacing.getMoveMinNumber()) {
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
