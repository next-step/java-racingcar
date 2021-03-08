package racingcar.util;

import java.util.Random;

public class RandomUtil {
    public static int randomNum(){
        return new Random().nextInt(10);
    }
}
