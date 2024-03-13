package racingcar.util;

import java.util.Random;

public abstract class AbstractRandomNumberFactory {

    protected static Random random = new Random();

    public abstract AbstractRandomNumber produce();

}
