package racinggame.util;

import racinggame.exception.ImpossibaleConstructionException;

import java.util.Random;

/**
 * 1. 0~9 사이의 random 값을 구하는 기능
 * 1. 값이 정수 인지 체크
 * 1. String을 int로 변환, 반환, 검증
 */
public final class NumberUtil {

    private NumberUtil() {
        throw new ImpossibaleConstructionException("Util 객체 생성 금지");
    }

    public static int createRandomInt(int bound) {
        return new Random().nextInt(bound);
    }

    public static boolean isGreaterThan(int num, int compare) {
        return num >= compare;
    }

    /**
     * 값이 정수 인지 체크
     * <p>
     * 이 메서드는 indent를 어떻게 1로 줄일수 있을까요?
     */
    public static int validateIntegerAndReturn(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닌 값이 입력 되었습니다.");
        }
    }
}
