package com.iksoo.racer;

import java.util.Random;

public class RacingGame {
    private static int time;
    private static int[] carPositions;
    private static InputRacingValues inputRacingValues;
    private static OutputRacingValues outputRacingValues;
    private static Random random;

    public static void initiator() {
        inputRacingValues = new InputRacingValues();
        outputRacingValues = new OutputRacingValues();
        random = new Random();
    }

    public static void main (String[] args) {
        // 객체 초기화 메소드
        initiator();

        // 변수값 입력 메소드
        inputValues();

        System.out.println("\n실행결과");

        // 이동횟수 만큼 작업 시작
        for(int i = 0; i < time; i++) {
            move();
            System.out.println();
        }
    }

    public static void inputValues() {
        // 자동차 수 입력
        carPositions = new int[inputRacingValues.inputCars()];
        // 이동횟수 입력
        time = inputRacingValues.inputTrys();
    }

    public static void move () {
        // 각 자동차별 움직임 시작
        for(int i = 0; i < carPositions.length; i++) {
            // isGoStop이 true일 경우만 한 칸 전진
            carPositions[i] += isGoStop() ? 1 : 0;
            // 자동차들의 현재 상태 출력
            outputRacingValues.printLine(carPositions[i]);
        }
    }

    public static boolean isGoStop() {
        int randomValue = random.nextInt(10);

        // 랜던값이 4이상일 경우 true 아니면 false
        return randomValue >= 4 ? true : false;
    }
}