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

public class CarMain {

    public static void main(String[] args) {
        InputRacingInfo inputRacingInfo = new InputRacingInfo();

        String[] carNames = inputRacingInfo.getCarTotalNames().split(",");
        int tryOfNumbers = inputRacingInfo.getTryOfNumbers();

        Car[] cars = initiateCar(carNames, tryOfNumbers);
    }

    public static Car[] initiateCar(String[] carNames, int tryOfNumbers) {
        Car[] tempCars = new Car[tryOfNumbers];
        for (int i = 0; i < carNames.length; i++) {
            tempCars[i] = new Car(carNames[i]);
        }

        return tempCars;
    }

}
