package racingcar.utils;


public class RandomUtils {
    public static int createRandom() {
        return (int) (Math.random() * Constant.RANDOM_NUM) + Constant.NUMBER_1;
    }
}
