package racingcar.util;

import java.util.Random;

public class UtilContainer {
    private static final Random random = new Random();

    public static Random getRandom(){
        return random;
    }

    private UtilContainer(){}
}
