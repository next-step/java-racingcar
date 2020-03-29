package racinggame.util;

import racinggame.exception.ImpossibleConstructionException;
import racinggame.exception.NegativeNumberException;

import java.util.Random;

/**
 * 1. 0~9 사이의 random 값을 구하는 기능
 * 1. 값이 정수 인지 체크
 * 1. String을 int로 변환, 반환, 검증
 */
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
