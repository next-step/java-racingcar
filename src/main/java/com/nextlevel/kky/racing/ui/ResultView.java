package com.nextlevel.kky.racing.ui;

import com.nextlevel.kky.racing.core.Car;
import com.nextlevel.kky.racing.core.CarRacingExecutor;

public class ResultView {

    public static void printCarRacingResult(CarRacingExecutor carRacingExecutor) {
        for (Car car : carRacingExecutor.carList) {
            for (int i = 0; i < car.getCurrentPosition() + 1; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printCarRacingResultWithName(CarRacingExecutor carRacingExecutor) {
        for (Car car : carRacingExecutor.carList) {
            System.out.print(car.getName() + ": ");
            for (int i = 0; i < car.getCurrentPosition() + 1; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
