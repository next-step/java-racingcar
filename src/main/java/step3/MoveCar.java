package step3;

import java.util.Random;

public class MoveCar {

    public static boolean moveCondition() {
        int randomVal = new Random().nextInt(10);

        if(randomVal < 4) return false;

        return true;
    }
}
