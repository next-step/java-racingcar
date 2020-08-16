package racingcarbasic;

import java.util.Random;

public class RacingCar {
    String name;
    int step;

    public RacingCar(String name, int step) {
        this.name = name;
        this.step = step;
    }

    public int[] getMoveCount(int[] carMoveNum) {

        for (int i = 0; i < carMoveNum.length; i++) {
            if (move(getRandomNum())) {
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
        return randomNum >= 4;
    }
}
