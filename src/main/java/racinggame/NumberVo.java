package racinggame;

import java.util.Random;

/**
 * 1. 0~9 사이의 random 값을 구하는 기능
 * 1. 값이 정수 인지 체크 및 반환
 * 1. 값이 1 이상인치 체크
 * 1. 값이 4 이상인치 체크
 */
public class NumberVo {

    private NumberVo() {
    }

    /**
     * 0~9 사이의 random 값을 구하는 기능
     */
    protected static int createRandomNumber() {
        return new Random().nextInt(10);
    }

    /**
     * 값이 4 이상인치 체크
     */
    protected static boolean isGreaterThan4(int num) {
        if (num >= 4) {
            return true;
        }
        return false;
    }

    /**
     * 값이 1 이상인치 체크
     */
    protected static boolean isGreaterThan1(int num) {
        if (num >= 1) {
            return true;
        }
        return false;
    }

    /**
     * 값이 정수 인지 체크 및 반환
     */
    protected static int validateInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닌 값이 입력 되었습니다.");
        }
    }
}
