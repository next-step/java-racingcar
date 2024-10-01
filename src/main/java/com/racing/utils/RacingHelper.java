package com.racing.utils;

import java.util.Random;

/**
 * 레이싱에서 사용 할 헬퍼 메서드를 모아놓은 클래스
 */
public class RacingHelper {
    private static final int RANDOM_NUMBER = 10;

    /**
     * 0~9의 랜덤 값 반환
     */
    public static int getRandomNumber() {
        Random rand = new Random();

        return rand.nextInt(RANDOM_NUMBER);
    }
}
