package racinggame.util;

import racinggame.exception.ImpossibleConstructionException;
import racinggame.exception.NegativeNumberException;

import java.util.Random;

public final class NumberUtil {

    private NumberUtil() {
        throw new ImpossibleConstructionException(getClass().getName());
    }

    public static int createRandomInt(int bound) {
        return new Random().nextInt(bound);
    }

    public static boolean isGreaterThan(int num, int compare) {
        return num >= compare;
    }

    public static int validateIntegerAndReturn(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new NegativeNumberException("정수가 아닌 값이 입력 되었습니다.");
        }
    }
}
