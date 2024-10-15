package com.racing.ui;

import com.racing.domain.Cars;

public class ResultView {
    public static void printStartMessage() {
        System.out.println("실행 결과");
    }

    public static void printRoundResult(int round, Cars cars) {
        System.out.println("# " + round + "회차");

        cars.printRacingPositions();

        System.out.println();
    }

    public static void printWinners(Cars winners) {
        System.out.print("최종 우승자: ");
        int winnerSize = winners.carsSize();
        for (int i = 0; i < winnerSize; i++) {
            System.out.print(winners.getCarName(i));
            printComma(i < winnerSize - 1);
        }

        System.out.println();
    }

    private static void printComma(boolean isComma) {
        if (isComma) {
            System.out.print(", ");
        }
    }
}