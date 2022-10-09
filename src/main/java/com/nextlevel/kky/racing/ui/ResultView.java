package com.nextlevel.kky.racing.ui;

import com.nextlevel.kky.racing.core.Car;
import com.nextlevel.kky.racing.core.CarRacingExecutor;

import java.util.List;

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

    public static void printCarWinners(List<Car> carList) {
        carList.forEach(car -> System.out.print(car.getName() + " "));
        System.out.println("가 최종 우승했습니다.");
    }
}
