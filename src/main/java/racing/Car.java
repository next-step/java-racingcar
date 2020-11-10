package racing;

import java.util.Random;

public class Car {

    private int carPosition = 0;

    public void movePosition() {
        int randomNumber = new Random().nextInt(10);
        if (randomNumber >= 4) {
            carPosition++;
        }
    }

    public int getCarPosition() {
        return carPosition;
    }
}
