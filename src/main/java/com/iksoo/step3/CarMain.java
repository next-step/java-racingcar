/*
 * ClassName : CarMain.java
 *
 * Version : 1.0
 *
 * Create Date : 2019.06.17
 *
 * Creator : 신익수
 *
 */
package com.iksoo.step3;

import java.util.List;
import java.util.Random;

public class CarMain {
    //private static final long RANDOM_SEED = 190618;
    private static final int GOSTOP_CRITERION = 4;
    private static Random random = new Random();
    private static OutputRacingData outputRacingInfo;

    public static void main(String[] args) {
        CheckRacingWinner checkRacingWinner = new CheckRacingWinner();
        InputRacingInfo inputRacingInfo = new InputRacingInfo();
        outputRacingInfo = new OutputRacingData();

        String[] carNames = inputRacingInfo.inputCarNames().split(",");
        int tryOfNumbers = inputRacingInfo.inputTryOfNumber();

        Car[] cars = initiateCar(carNames);

        startRacing(cars, tryOfNumbers);

        List<Object> winner = checkRacingWinner.checkResult(cars);

        outputRacingInfo.printFinalResult(cars, tryOfNumbers, winner);
    }

    public static Car[] initiateCar(String[] carNames) {
        Car[] tempCars = new Car[carNames.length];

        for (int i = 0; i < carNames.length; i++) {
            tempCars[i] = new Car(carNames[i]);
        }

        return tempCars;
    }

    public static void startRacing(Car[] cars, int tryOfNumbers) {
        for (int i = 0; i < tryOfNumbers; i++) {
            doOneInning(cars);
            outputRacingInfo.printEachInning(cars);
        }
    }

    public static void doOneInning(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            //cars[i].addCarPosition(judgeGoOrStop(getRandom()));
        }
    }

    public static String judgeGoOrStop(int random) {
        if (random >= GOSTOP_CRITERION) {
            return "1";
        }
        return "0";
    }

    public static int getRandom() {
        return random.nextInt(10);
    }
}