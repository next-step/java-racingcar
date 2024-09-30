package com.warmup.step3;

import java.util.Random;
import java.util.Scanner;

public class CarRacing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNumber = scanner.nextInt();

        System.out.println("시도할 횟수는 몇 회 인가요?");
        int tryNumber = scanner.nextInt();

        System.out.println("자동차 대수: " + carNumber + " 시도할 횟수: " + tryNumber);
    }

    /**
     * 랜덤하게 진행 여부를 확인하여 Dash를 더해 전달
     */
    private static String addRandomDashString(String carStatus) {
        boolean doForward = isForward(getRandomNumber());
        if (doForward) {
            carStatus = addDash(carStatus);
        }

        System.out.println(carStatus);

        return carStatus;
    }

    /**
     * 입력한 숫자만큼의 문자열 배열 반환
     */
    public static String[] makeStringArray(int size) {
        return new String[size];
    }

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
