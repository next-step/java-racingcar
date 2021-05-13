package racingCar;

import java.util.Random;

public class Function {
    public static int drawNumber(){
        Random random = new Random();
        return random.nextInt(10);
    }

    public Boolean moveAble(int number) {
        return number >= 4;
    }

    public String getScore(boolean movable) {
        if (movable) {
            return "-";
        }
        return null;
    }
}
