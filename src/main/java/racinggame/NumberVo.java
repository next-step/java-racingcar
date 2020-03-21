package racinggame;

import java.util.Random;

/**
 * 1. 0~9 사이의 random 값을 구하는 기능
 * 1. 값이 4 이상인치 체크
 */
public class NumberVo {

    private int num;

    public NumberVo(int num) {
        this.num = num;
    }

    /**
     * 0~9 사이의 random 값 생성
     */
    public static int createRandomNumber() {
        return new Random().nextInt(10);
    }

    /**
     * 입력값이 4 이상인치 체크
     */
    public boolean isGreaterThan4() {
        if (this.num >= 4) {
            return true;
        }
        return false;
    }
}
