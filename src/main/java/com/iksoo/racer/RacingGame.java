package com.iksoo.racer;

import java.util.Random;

public class RacingGame {
    private static InputRacingValues inputRacingValues;
    private static OutputRacingValues outputRacingValues;
    private static Random random;

    private static final int GOSTOP_CRITERION = 4;

    public static void initiateObjects() {
        inputRacingValues = new InputRacingValues();
        outputRacingValues = new OutputRacingValues();
        random = new Random();
    }

    public static void main(String[] args) {
        initiateObjects();

        int[] carPositions = new int[inputRacingValues.inputCars()];
        int times = inputRacingValues.inputTrys();

        System.out.println("\n실행결과");

        move(carPositions, times);
    }

    public static void move(int[] carPositions, int times) {
        for (int i = 0; i < times; i++) {
            moveOneByOne(carPositions);

            outputRacingValues.printPositions(carPositions);
        }
    }

    public static void moveOneByOne(int[] carPositions) {
        for (int i = 0; i < carPositions.length; i++) {
            carPositions[i] += goOrStop();
        }
    }

    public static int goOrStop() {
        return GOSTOP_CRITERION <= getRandom() ? 1 : 0;
    }

    public static int getRandom() {
        return random.nextInt(10);
    }
}