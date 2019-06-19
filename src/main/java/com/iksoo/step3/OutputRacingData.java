package com.iksoo.step3;

import java.util.List;

public class OutputRacingData {
    public void printBlankLine() {
        System.out.println();
    }

    public void printFinalResult(Car[] car, int tryOfNumber, List<Object> winner) {
        System.out.println("\n실행 결과");

        for (int i = 0; i < tryOfNumber; i++) {
            printEachInning(car, i+1);
        }

        printWinner(winner);
    }

    public void printEachInning(Car[] car, int inning) {
        for (int i = 0; i < car.length; i++) {
            printResultOfOne(car[i].getCarName(), car[i].getCarPosition(), inning);
        }
        printBlankLine();
    }

    public void printResultOfOne(String carName, String carPosition, int inning) {
        System.out.print(carName + " : ");
        for (int i = 0; i < inning; i++) {
            System.out.print(carPosition.charAt(i) == '1' ? "-" : "");
        }
        printBlankLine();
    }

    public void printWinner(List<Object> winner) {
        System.out.print(winner);
        System.out.print("가 최종 우승했습니다.");
    }
}
