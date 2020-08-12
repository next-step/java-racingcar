package racingcarbasic;

import java.util.Random;

public class RacingCar {
    public int[] getMoveCount (int[] carMoveNum) {
        Random random = new Random();
        for (int i=0; i< carMoveNum.length; i++) {
            int randomNum = random.nextInt(10);

            if(randomNum>=4) {
                carMoveNum[i]++;
            }
        }

        return carMoveNum;
    }
}
