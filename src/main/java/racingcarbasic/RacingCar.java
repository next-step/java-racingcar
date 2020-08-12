package racingcarbasic;

import java.util.Random;

public class RacingCar {
    public int[] getMoveCount (int[] carMoveNum) {

        for (int i=0; i< carMoveNum.length; i++) {
            if(move(getRandomNum())) {
                carMoveNum[i]++;
            }
        }

        return carMoveNum;
    }

    public int getRandomNum() {
        Random random = new Random();
        int randomNum = random.nextInt(10);

        return randomNum;
    }

    public boolean move(int randomNum) {
        if(randomNum>=4) {
            return true;
        }
        return false;
    }
}
