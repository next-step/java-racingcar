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

import java.util.ArrayList;
import java.util.List;

public class CarMain {
    private static OutputRacingData outputRacingInfo;

    public static void main(String[] args) {
        CheckRacingWinner checkRacingWinner = new CheckRacingWinner();
        InputRacingInfo inputRacingInfo = new InputRacingInfo();
        outputRacingInfo = new OutputRacingData();

        String[] carNames = inputRacingInfo.inputCarNames().split(",");
        int tryOfNumbers = inputRacingInfo.inputTryOfNumber();

        CarRacer cars = new CarRacer(initiateCar(carNames, tryOfNumbers));
        List<Object> winner = checkRacingWinner.checkWinner(cars.getCars());
        outputRacingInfo.printFinalResult(winner);
    }

    public static List<Car> initiateCar(String[] carNames, int tryOfNumbers) {
        outputRacingInfo.printRacingStart();

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i], tryOfNumbers));
        }

        return cars;
    }
}