package com.warmup.step3;

import java.util.Random;

public class CarRacing {

    /**
     * 0~9의 랜덤 값 반환
     */
    public static int getRandomNumber() {
        Random rand = new Random();

        return rand.nextInt(10);
    }

    /**
     * 문자열에 대시를 추가하는 함수
     */
    public static String addDash(String input) {
        return input + "-";
    }

    /**
     * 전진 여부 판단
     */
    public static boolean isForward(int input) {
        return input >= 4;
    }
}
