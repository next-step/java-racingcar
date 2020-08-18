package carracing.domain;

import java.util.Random;

public class Car {

    private static final int MOVE_POSITION = 4;

    private int position = 0;
    private int carNumber;
    private String output = "";

    public Car(int carNumber) {
        this.carNumber = carNumber;
    }

    private int getPower() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public void setPosition() {
        if(getPower() < MOVE_POSITION) {
            return;
        }
        position++;
    }

    public int getPosition() {
        return position;
    }

    public int getCarNumber() {
        return this.carNumber;
    }

}
