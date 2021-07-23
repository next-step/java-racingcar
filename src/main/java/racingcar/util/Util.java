package racingcar.util;

import java.util.Random;

public class Util {

    public static int generateRandom(){
        Random random = new Random();
        return random.nextInt(10);
    }
}
