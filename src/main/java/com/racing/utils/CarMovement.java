package com.racing.utils;

import java.util.Random;

/**
 * 레이싱에서 사용 할 헬퍼 메서드를 모아놓은 클래스
 */
public class CarMovement implements MovementStrategy {
    private static final int RANDOM_NUMBER_RANGE = 10;
    private static final int FORWARD_MINIMUM_NUMBER = 4;

    /**
     * Helper 클래스 내부에서 shouldMove 직접 구현
     */
    @Override
    public boolean shouldMove() {
        int randomNumber = getRandomNumber();
        return isForward(randomNumber);
    }

    /**
     * 0~9의 랜덤 값 반환
     */
    public static int getRandomNumber() {
        Random rand = new Random();

        return rand.nextInt(RANDOM_NUMBER_RANGE);
    }

    /**
     * 전진 여부 반환
     */
    public static boolean isForward(int input) {
        return input >= FORWARD_MINIMUM_NUMBER;
    }
}
