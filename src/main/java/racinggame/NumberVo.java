package racinggame;

import java.util.Random;

/**
 * 1. 0~9 사이의 random 값을 구하는 기능
 * 1. 값이 정수 인지 체크
 * 1. 값이 1 이상인치 체크
 * 1. 값이 4 이상인치 체크
 * 1. 게임 진행시 자동차 이동
 */
public class NumberVo {

    private NumberVo() {
    }

    /**
     * 0~9 사이의 random 값을 구하는 기능
     */
    public static int createRandomNumber() {
        return new Random().nextInt(10);
    }

    /**
     * 값이 4 이상인치 체크
     */
    public static boolean isGreaterThan4(int num) {
        if (num >= 4) {
            return true;
        }
        return false;
    }
}
