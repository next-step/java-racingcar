package com.iksoo.step4.view;

import com.iksoo.step4.model.Car;

import java.util.List;

public class CarOutputData {

    public static void printRacingStart() {
        printBlankLine();
        printTextln("실행 결과");
        printBlankLine();
    }

    public static void printFinalResult(List<Car> cars, List<String> winnersName) {
        printRacingHistory(cars);
        printText(winnersName);
        printText("가 최종 우승했습니다.");
    }

    public static void printRacingHistory(List<Car> cars) {
        int totalInning = cars.get(0).getTotalInning();
        for (int i = 1; i <= totalInning; i++) {
            printInningHistory(cars, i);
            printBlankLine();
        }
    }

    public static void printInningHistory(List<Car> cars, int inning) {
        for (int i = 0; i < cars.size(); i++) {
            printTextln(cars.get(i).getRanHistory(inning));
        }
    }

    public static void printBlankLine() {
        System.out.println();
    }

    public static void printText(List<String> text) {
        System.out.print(text);
    }

    public static void printText(String text) {
        System.out.print(text);
    }

    public static void printTextln(String text) {
        System.out.println(text);
    }
}
