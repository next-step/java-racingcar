package com.warmup.step3;

public class CarRacing {

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
        return input > 3;
    }
}
