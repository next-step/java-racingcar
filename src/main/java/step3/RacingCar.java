package step3;

import java.util.Random;

public class RacingCar {
    private int distance = 0;

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public boolean isMove(int randomNumber) {
        if(randomNumber > 4) {
            return true;
        }
        return false;
    }

    public void move() {
        if(isMove(getRandomNumber())) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }


}
