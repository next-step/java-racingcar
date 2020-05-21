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

    public static void print(List<Car> cars) {
        sleepOneSecondForPrint();
        for (Car car : cars) {
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
        System.out.print(car.getName() + " : ");
        for (int i = 0; i <= car.getPosition(); i++) {
            System.out.print(CAR_POSITION_DISPLAY);
        }
        System.out.println();
    }

    public static void printWinner(List<Car> cars) {
        String winners = cars.stream()
                .map(Car::getName)
                .reduce((s, s2) -> String.join(", ", s, s2))
                .get();

        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
