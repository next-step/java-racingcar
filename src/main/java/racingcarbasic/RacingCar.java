package racingcarbasic;

import java.util.Random;

public class RacingCar {
    public int[] getMoveCount (int[] carMoveNum) {

        for (int i=0; i< carMoveNum.length; i++) {
            if(move()) {
                carMoveNum[i]++;
            }
        }

        return carMoveNum;
    }

    public boolean move() {
        Random random = new Random();
        int randomNum = random.nextInt(10);

        if(randomNum>=4) {
            return true;
        }
        return false;
    }
}
