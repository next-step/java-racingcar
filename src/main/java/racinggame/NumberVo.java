package racinggame;

import java.util.Random;

/**
 * 1. 0~9 사이의 random 값을 구하는 기능
 * 1. 입력값이 4 이상인치 체크
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

}
