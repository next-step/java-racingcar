package com.kimdahyeee.racing.view;

import com.kimdahyeee.racing.Car;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ResultView {
    private static final String CAR_POSITION_DISPLAY = "-";
    private static final int TIME_TO_SLEEP = 1;

    public static void printHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void print(List<Car> carPositions) {
        sleepOneSecondForPrint();
        for (Car car : carPositions) {
            printByOneCar(car);
        }
        System.out.println();
    }

    private static void sleepOneSecondForPrint() {
        try {
            TimeUnit.SECONDS.sleep(TIME_TO_SLEEP);
        } catch (InterruptedException e) {
            throw new RuntimeException("timeUnit 오류 : ", e);
        }
    }

    private static void printByOneCar(Car car) {
        for (int i = 0; i <= car.getPosition(); i++) {
            System.out.print(CAR_POSITION_DISPLAY);
        }
        System.out.println();
    }

}
