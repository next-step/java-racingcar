package racingCar;

import java.util.Random;

public class Function {
    public static int drawNumber(){
        Random random = new Random();
        return random.nextInt(10);
    }
}
