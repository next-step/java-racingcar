package step5.util;

import java.util.Random;

public class RandomGame {
    static Random rd = new Random();
    public boolean throwDice() {
        int randNum = rd.nextInt(10);
        if (randNum >= 4) {
            return true;
        }
        return false;
    }
}
